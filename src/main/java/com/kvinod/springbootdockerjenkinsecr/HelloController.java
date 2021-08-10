package com.kvinod.springbootdockerjenkinsecr;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/hello")
public class HelloController {
    
    @GetMapping
    public Map<String, Object> hello(){
        log.info("received GET request for /api/hello");
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Hello, world!");
        map.put("timestamp", new Date());
        return map;
    }
}
