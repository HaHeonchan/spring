package com.seq.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String main(){
        return "Hello World";
    }

    @GetMapping("/login")
    String login(){
        return "login.html";
    }
}
