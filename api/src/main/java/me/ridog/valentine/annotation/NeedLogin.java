package me.ridog.valentine.annotation;

import java.lang.annotation.*;

/**
 * Created by Tate on 2016/7/15.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface NeedLogin {
}
