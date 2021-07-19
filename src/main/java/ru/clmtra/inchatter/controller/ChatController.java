package ru.clmtra.inchatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @RequestMapping("/success")
    public String successPage() {
        return "success";
    }
}
