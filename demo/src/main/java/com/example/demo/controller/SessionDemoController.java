package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo")
public class SessionDemoController {
    @GetMapping("/session")
    public Map<String,Object> test(HttpServletRequest servletRequest) {
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId",servletRequest.getSession().getId());
        map.put("username",servletRequest.getSession().getAttribute("username"));
        return map;
    }
    @GetMapping("/clear")
    public Map<String, Object> clear(HttpServletRequest servletRequest){
        Map<String, Object> map = new HashMap<>();
        servletRequest.getSession().removeAttribute("username");
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }
}
