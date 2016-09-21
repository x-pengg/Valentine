package me.ridog.valentine.filter;

import me.ridog.valentine.util.LogUitls;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tate on 2016/8/1.
 */
@Component
public class HttpFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        LogUitls.info("HttpFilter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LogUitls.info("Filtering on...........................................................");


        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "x-requested-with");

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
