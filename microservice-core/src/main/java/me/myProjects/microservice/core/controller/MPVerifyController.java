package me.myProjects.microservice.core.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MPVerifyController {


    @RequestMapping(value = "/MP_verify_{key}.txt", method = RequestMethod.GET, produces = "text/plain")
    public String verify4WeChat(@PathVariable String key) {
        return key;
    }


}
