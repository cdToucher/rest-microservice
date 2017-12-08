package me.myProjects.microservice.core.controller;

import com.alibaba.fastjson.JSON;
import me.myProjects.microservice.core.dao.UserDao;
import me.myProjects.microservice.core.utils.ParamsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static me.myProjects.microservice.core.constant.RequestParam.TENANT_ID;

/**
 * rest controller
 */
@RestController
@RequestMapping("/v1/") // 加入版本号有助于 控制api 的版本信息
public class RestfulController {

    private final AsyncMethods asyncMethods;

    private final UserDao userDao;

    @Autowired
    public RestfulController(UserDao userDao, AsyncMethods asyncMethods) {
        this.userDao = userDao;
        this.asyncMethods = asyncMethods;
    }


    @RequestMapping(value = {"/test"}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String restTest() throws InterruptedException {

        int successNum = 0;

/*        UserInfo userInfo = new UserInfo();
        userInfo.setName("test");
        userInfo.setEmail("614141165@qq.com");
        userInfo.setPhone("18700000000");
        userInfo.setDescription("something");
        successNum = userDao.addUser(userInfo);*/

//        userDao.deleteUser(4);

        String tenantId = ParamsHolder.getParamString(TENANT_ID.getName());
        Map<String, Object> map = new HashMap<>();
        map.put("successNum", successNum);
        asyncMethods.doLater();
        return JSON.toJSONString(map);
    }

}