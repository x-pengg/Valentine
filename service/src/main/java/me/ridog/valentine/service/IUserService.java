package me.ridog.valentine.service;


import me.ridog.valentine.result.UserResult;

/**
 * Created by Tate on 2016/7/21.
 */
public interface IUserService {

    UserResult getUser(Integer id);

    UserResult login(String username, String password);

    void register(String username, String password, String mail);
}
