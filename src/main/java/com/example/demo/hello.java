package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//前端请求响应
@RestController
public class hello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello SpringBoot!";
    }

}

/**
 * <!--这是github开源仓库-->
 *     更新至开源仓库，实验仓库。
*实验仓库
*
*
* */