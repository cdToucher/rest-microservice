package me.myProjects.microservice.core.dao.impl;

import me.myProjects.microservice.core.bean.orm.UserInfo;
import me.myProjects.microservice.core.dao.UserDao;
import me.myProjects.microservice.core.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by chendong on 2017/4/24.
 * <p>
 * orm service impl
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final UserInfoMapper mapper;

    @Autowired
    public UserDaoImpl(UserInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int addUser(UserInfo info) {
        return mapper.insert(info);
    }

    @Override
    public int updateUser(UserInfo info) {
        return 0;
    }


    @Override
    public void deleteUser(long id) {
         mapper.deleteById(id);
    }

    @Override
    public UserInfo queryUserById(List<Long> ids) {
        return null;
    }

    @Override
    public List<UserInfo> queryUserBy(Map<String, Object> params) {
        return null;
    }
}
