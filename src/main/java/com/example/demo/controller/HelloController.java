package com.example.demo.controller;

import com.example.demo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhaoGQ
 */
@RestController
@RequestMapping("/say")
public class HelloController {
   /* @Value("${cupSize}")
    private String cupSize;*/

    @Autowired
    private GirlProperties girlProperties;

    //@RequestMapping(value = {"/hello"},method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "Hello spring boot45111！65" + myId;
        //return "index";
    }
}
