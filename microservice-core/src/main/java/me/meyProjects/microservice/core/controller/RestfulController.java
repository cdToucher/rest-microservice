package me.meyProjects.microservice.core.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static me.meyProjects.microservice.core.constant.RequestParam.TENANT_ID;
import static me.meyProjects.microservice.core.utils.ParamsHolder.getParamString;

/**
 * rest controller
 */
@RestController
@RequestMapping("/api/") // 加入版本号有助于 控制api 的版本信息
public class RestfulController {

    @RequestMapping(value = {"v1/test", ""}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String restTest() {
        String tenantId = getParamString(TENANT_ID.getName());
        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        return JSON.toJSONString(map);
    }

}