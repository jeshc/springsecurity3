package com.jeshc.carssec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @GetMapping("/")
    public String getManage() {
        return "manage";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "users";
    }

}
