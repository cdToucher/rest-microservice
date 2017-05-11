package me.myProjects.microservice.core.dao.impl;

import me.myProjects.microservice.core.bean.orm.UserInfo;
import me.myProjects.microservice.core.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by chendong on 2017/4/24.
 *
 * jdbc t
 */
//@Repository
public class JdbcUserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcUserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(UserInfo info) {
        return jdbcTemplate.getMaxRows();
    }

    @Override
    public int updateUser(UserInfo info) {
        return 0;
    }

    @Override
    public void deleteUser(long id) {

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
