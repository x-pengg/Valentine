package me.ridog.valentine.service.impl;

import me.ridog.valentine.mapper.auto.UserMapper;
import me.ridog.valentine.pojo.auto.User;
import me.ridog.valentine.result.UserResult;
import me.ridog.valentine.service.IUserService;
import me.ridog.valentine.util.LogUitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tate on 2016/7/21.
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    UserMapper userMapper;

    public void createUser(User user) {

        LogUitls.info("创建新用户");

        userMapper.insert(user);

    }

    public UserResult getUser(Integer id) {
        LogUitls.info("获取用户, ID:" + id);
        User user = userMapper.selectByPrimaryKey(id);
        if (user==null) {
            throw new NullPointerException();
        }
        UserResult userResult = new UserResult();
        userResult.setId(user.getUid());
        userResult.setUsername(user.getName());
        userResult.setMail(user.getMail());
        userResult.setCreated(user.getCreated());
        userResult.setActivated(user.getActivated());
        return userResult;
    }
}
