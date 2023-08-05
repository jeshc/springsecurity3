package com.jeshc.carssec.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getManage() {
        return "manage";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getUsers() {
        return "users";
    }

}
