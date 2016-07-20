package me.ridog.valentine.controller;

import me.ridog.valentine.annotation.NeedLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Tate on 2016/7/15.
 */

@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String hello() {
        return "你好，单词！";
    }

    @RequestMapping("index")
    @ResponseBody
    @NeedLogin
    public String index() {
        return "你好，用户！";
    }
}
