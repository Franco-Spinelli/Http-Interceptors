package com.example.fifth_project_interceptor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class FooController {
    @GetMapping("/foo")
    public Map<String,String> foo(){
        return Collections.singletonMap("message","handler foo from the controller");
    }
    @GetMapping("/bar")
    public Map<String,String> bar(){
        return Collections.singletonMap("message","handler bar from the controller");
    }
    @GetMapping("/baz")
    public Map<String,String> baz(){
        return Collections.singletonMap("message","handler baz from the controller");
    }
}
