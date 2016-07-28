package me.ridog.valentine.service;


import me.ridog.valentine.pojo.auto.User;
import me.ridog.valentine.result.UserResult;

/**
 * Created by Tate on 2016/7/21.
 */
public interface IUserService {

    void createUser(User user);

    UserResult getUser(Integer id);
}
