package me.ridog.valentine.controller.error;

import me.ridog.valentine.resp.APIResult;
import me.ridog.valentine.resp.ErrorCode;
import me.ridog.valentine.exception.BlogException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tate on 2016/7/29.
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String rs = errMsg(ex);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(rs);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
        }
        return null;
    }

    public String errMsg(Exception ex){
        if (ex instanceof BlogException) {
            return APIResult.newRs().fail().errCode(((BlogException) ex).getCode()).errMsg(((BlogException) ex).getMsg()).build();
        } else if (ex instanceof IllegalArgumentException || ex instanceof MissingServletRequestParameterException) {
            return APIResult.newRs().fail().errCode(ErrorCode.PARAM_ERROR).errMsg("参数错误").build();
        }else{
            return APIResult.newRs().fail().errCode(ErrorCode.SYSTEM_BUSY).errMsg("系统繁忙").build();
        }

    }
}
