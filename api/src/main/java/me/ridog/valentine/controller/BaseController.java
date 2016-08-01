package me.ridog.valentine.controller;

import me.ridog.valentine.filter.RequestContext;

/**
 * Created by chan on 16/7/30.
 */
public class BaseController {

    public RequestContext ctx() {
        return RequestContext.get();
    }

}
