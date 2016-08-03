package me.ridog.valentine.service.impl;

import me.ridog.valentine.mapper.auto.UserMapper;
import me.ridog.valentine.pojo.auto.User;
import me.ridog.valentine.resp.ErrorCode;
import me.ridog.valentine.exception.BlogException;
import me.ridog.valentine.mapper.IUserMapper;
import me.ridog.valentine.result.UserResult;
import me.ridog.valentine.service.IUserService;
import me.ridog.valentine.util.LogUitls;
import me.ridog.valentine.util.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Tate on 2016/7/21.
 */
@Service
public class UserServiceImpl implements IUserService {


    @Resource
    UserMapper userMapper;
    @Resource
    IUserMapper userMapperEx;

    public void createUser(User user) {

        LogUitls.info("创建新用户");

        userMapper.insert(user);

    }

    public UserResult getUser(Integer id) {
        LogUitls.info("获取用户, ID:" + id);
        User user = userMapper.selectByPrimaryKey(id);
        if (null == user) {
            throw new BlogException(ErrorCode.ACCOUNT_INVALID, "用户不存在");
        }
        UserResult userResult = userResult(user);
        return userResult;
    }

    private UserResult userResult(User user) {
        UserResult userResult = new UserResult();
        userResult.setId(user.getUid());
        userResult.setUsername(user.getName());
        userResult.setMail(user.getMail());
        userResult.setCreated(user.getCreated());
        userResult.setActivated(user.getActivated());
        return userResult;
    }

    public UserResult login(String username, String password) {
        User user = userMapperEx.select(username, MD5Utils.MD5(password));
        if (null == user) {
            LogUitls.info("登录,用户名或密码错误");
            throw new BlogException(ErrorCode.AUTH_ERROR, "用户名或密码错误");
        }
        return userResult(user);
    }

    public void register(String username, String password, String mail) {
        if (null != userMapperEx.selectByMail(mail)) {
            throw new BlogException(ErrorCode.ACCOUNT_EXIST, "邮箱已被注册");
        }
        if (null != userMapperEx.selectByName(username)) {
            throw new BlogException(ErrorCode.ACCOUNT_EXIST, "账号已被注册");
        }
        User user = new User();
        user.setName(username);
        user.setPassword(MD5Utils.MD5(password));
        user.setMail(mail);
        user.setCreated(new Date());
        userMapper.insert(user);
        LogUitls.info("新用户注册");
    }
}
