package me.ridog.valentine.filter;

import me.ridog.valentine.util.LogUitls;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tate on 2016/8/1.
 */
public class HttpFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        LogUitls.info("HttpFilter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        try {
            RequestContext.init(null, req, resp);
            chain.doFilter(request, response);
        } finally {
            if (RequestContext.get() != null) {
                RequestContext.get().destroy();
            }
        }
    }

    public void destroy() {
        LogUitls.info("HttpFilter destroy");
    }
}
