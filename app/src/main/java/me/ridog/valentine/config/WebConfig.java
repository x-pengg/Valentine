package me.ridog.valentine.config;

import me.ridog.valentine.filter.CORSFilter;
import me.ridog.valentine.filter.TestFilter;
import me.ridog.valentine.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Tate on 2016/7/15.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }

    @Bean
    public CORSFilter CORSFilter() {
        return new CORSFilter();
    }

    @Bean
    public TestFilter testFilter() {
        return new TestFilter();
    }

}
