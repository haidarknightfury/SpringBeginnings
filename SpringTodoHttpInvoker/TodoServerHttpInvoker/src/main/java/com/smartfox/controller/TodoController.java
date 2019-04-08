package com.smartfox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

    @RequestMapping("/baka")
    @ResponseBody
    public String getBaka() {
        return "baka";
    }

}
