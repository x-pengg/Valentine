package me.ridog.valentine.interceptor;

import me.ridog.valentine.db.Page;
import me.ridog.valentine.util.LogUitls;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Tate on 2016/8/2.
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class PageInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable {
        LogUitls.info("PageInterceptor...");

        if (invocation.getTarget() instanceof StatementHandler) {
            StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
            MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
            Object parameterObject = boundSql.getParameterObject();
            // 重写分页
            if (null != parameterObject) {
                Page<?> page = (Page<?>) (parameterObject);
                if (null != page) {
                    String sql = boundSql.getSql();
                    logger.debug("buildPageSql before:{}", sql);
                    Connection connection = (Connection) invocation.getArgs()[0];
                    setPageParameter(sql, connection, page);
                    if (page.getTotalRecord() == 0) {
                        return invocation.proceed();
                    }
                    String pageSql = buildPageSql(sql, page);
                    logger.debug("buildPageSql after:{}", sql);
                    metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
                }
            }
        }

        return invocation.proceed();
    }


    public Object plugin(Object o) {
        if (o instanceof StatementHandler) {
            return Plugin.wrap(o, this);
        } else {
            return o;
        }
    }

    public void setProperties(Properties properties) {
    }

    private void setPageParameter(String sql, Connection connection, Page<?> page) {
        String countSql = buildCountSql(sql);
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        int totalCount = 0;
        try {
            logger.debug("buildCountSql after:{}", countSql);
            countStmt = connection.prepareStatement(countSql);
            rs = countStmt.executeQuery();

            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            // 总记录数
            page.setTotalRecord(totalCount);
            int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
            // 总条数
            page.setTotalPage(totalPage);
        } catch (SQLException e) {

        } finally {
            try {
                rs.close();
                countStmt.close();
            } catch (SQLException e) {
            }
        }

    }

    private String buildCountSql(String sql) {
        //+ sql.lastIndexOf("order by")>0
        sql = sql.lastIndexOf("order by") > 0 ? sql.substring(0, sql.lastIndexOf("order by")) : sql;
        return "select count(1) from (" + sql + ") total";
    }

    private String buildPageSql(String sql, Page<?> page) {
        StringBuilder pageSql = new StringBuilder(sql);
        int pageSize = page.getPageSize();
        if (pageSize > 0) {
            pageSql.append(" limit ").append((page.getPageNo() - 1) * page.getPageSize()).append(" , ").append(pageSize);
        }
        return pageSql.toString();
    }

}
