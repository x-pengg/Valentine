package me.ridog.valentine;

/**
 * Created by Tate on 2016/7/29.
 *
 * 1xxxxx为系统级别错误
 * 2xxxxx为服务级别错误
 */
public class ErrorCode {

    // 执行成功
    public static final Integer EXECUTE_SUCCESS = 0;

    // 执行失败
    public static final Integer EXECUTE_FAIL = 1;

    // 系统繁忙
    public static final Integer SYSTEM_BUSY = 100001;

    // 参数错误
    public static final Integer PARAM_ERROR = 100002;

    // NotFound
    public static final Integer NOTFOUND = 100003;

    // 用户名或密码错误
    public static final Integer AUTH_ERROR = 200001;

    // 需要管理员登录
    public static final Integer NEED_LOGIN = 200002;


}
