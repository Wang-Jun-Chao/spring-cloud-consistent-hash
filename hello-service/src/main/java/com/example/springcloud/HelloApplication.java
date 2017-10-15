package com.example.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * Author: 王俊超
 * Date: 2017-10-15 12:03
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
@RestController
@SpringBootApplication
public class HelloApplication {

    private static Logger log = LoggerFactory.getLogger(HelloApplication.class);

    @RequestMapping(path = "/greeting/{name}")
    public String greet(@PathVariable(value = "name") String name, HttpServletRequest request) {
        return name + ". Server: " + request.getServerPort();
    }

    @RequestMapping(path = "/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
