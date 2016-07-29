package me.ridog.valentine.controller.admin;

import me.ridog.valentine.APIResult;
import me.ridog.valentine.annotation.NeedLogin;
import me.ridog.valentine.result.UserResult;
import me.ridog.valentine.service.IUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Tate on 2016/7/21.
 */
@RestController
@RequestMapping("api")
@NeedLogin
public class UserController {


    @Resource
    IUserService userService;

    @RequestMapping(value = "user/{id:[0-9]+}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Integer id) {
        UserResult user = userService.getUser(id);
        return APIResult.newRs().success().data(user).build();
    }
}
