package me.myProjects.microservice.core.dao;

import me.myProjects.microservice.core.bean.orm.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by chendong on 2017/4/24.
 * <p>
 * orm service
 */
public interface UserDao {

    int addUser(UserInfo info);

    int updateUser(UserInfo info);

    void deleteUser(long id);

    UserInfo queryUserById(List<Long> ids);

    List<UserInfo> queryUserBy(Map<String, Object> params);

}
