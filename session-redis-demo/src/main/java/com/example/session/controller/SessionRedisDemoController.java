package com.example.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo")
public class SessionRedisDemoController {
    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public Map<String, Object> firstResp (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("username", "wang");
        map.put("code",0);
        map.put("msg","ok");
        return map;
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    public Map<String, Object> sessions (HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("value", request.getSession().getAttribute("username"));
        return map;
    }
}
