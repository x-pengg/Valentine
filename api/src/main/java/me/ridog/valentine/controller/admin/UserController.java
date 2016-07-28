package me.ridog.valentine.controller.admin;

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
public class UserController {


    @Resource
    IUserService userService;

    @RequestMapping(value = "user/{id:[0-9]+}", method = RequestMethod.GET)
    public UserResult getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}
