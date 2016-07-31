package me.ridog.valentine.controller.admin;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import me.ridog.valentine.APIResult;
import me.ridog.valentine.annotation.NeedLogin;
import me.ridog.valentine.controller.BaseController;
import me.ridog.valentine.result.UserResult;
import me.ridog.valentine.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Tate on 2016/7/21.
 */
@RestController
@RequestMapping("api")
public class UserController extends BaseController {

    @Resource
    IUserService userService;

    @RequestMapping(value = "user/{id:[0-9]+}", method = RequestMethod.GET)
    @NeedLogin
    public String getUser(@PathVariable("id") Integer id) {
        UserResult user = userService.getUser(id);
        return APIResult.newRs().success().data(user).build();
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        Preconditions.checkArgument(!Strings.isNullOrEmpty(username));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password));

        userService.login(username, password);
        return APIResult.newRs().success().build();
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("mail") String mail) {

        Preconditions.checkArgument(!Strings.isNullOrEmpty(username));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(mail));

        userService.register(username, password, mail);
        return APIResult.newRs().success().build();
    }
}
