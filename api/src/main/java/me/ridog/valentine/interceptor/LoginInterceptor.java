package me.ridog.valentine.interceptor;

import com.alibaba.fastjson.JSON;
import me.ridog.valentine.APIResult;
import me.ridog.valentine.ErrorCode;
import me.ridog.valentine.annotation.NeedLogin;
import me.ridog.valentine.exception.BlogException;
import me.ridog.valentine.util.LogUitls;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tate on 2016/7/15.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            String uri = request.getRequestURI();
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LogUitls.info("URL:"+uri+"->method:" + handlerMethod.getBean().getClass()
                    .getSimpleName() + "." + handlerMethod
                    .getMethod().getName() + "   arguments:"+JSON.toJSONString(request.getParameterMap()));
            if (needLogin(handlerMethod)) {
                LogUitls.info("需要登录");
                throw new BlogException(ErrorCode.NEED_LOGIN, "需要登录");
            }

        }

        return super.preHandle(request, response, handler);
    }

    private boolean needLogin(HandlerMethod handlerMethod) {
        return AnnotationUtils.findAnnotation(handlerMethod.getMethod(), NeedLogin.class) != null
                || AnnotationUtils.findAnnotationDeclaringClass(NeedLogin.class, handlerMethod.getBean().getClass()) != null;
    }
}
