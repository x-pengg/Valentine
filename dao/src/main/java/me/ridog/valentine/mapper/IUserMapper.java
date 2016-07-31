package me.ridog.valentine.mapper;

import me.ridog.valentine.pojo.auto.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chan on 16/7/29.
 */
public interface IUserMapper {

    User select(@Param("username") String username, @Param("password") String password);

    User selectByMail(@Param("mail") String mail);

    User selectByName(@Param("name") String name);
}
