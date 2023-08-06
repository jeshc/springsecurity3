package com.jeshc.carssec.controller;

import com.jeshc.carssec.model.User;
import com.jeshc.carssec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @PreAuthorize("isAnonymous()")
    @GetMapping("/security/signup/")
    public String signup(Model model) {

        return "signup";
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping( path = "/security/signupDo/", consumes = "application/x-www-form-urlencoded;charset=UTF-8" )
    public String signupPost(@ModelAttribute User newUser, Model model) {
        newUser.setPassword(    passwordEncoder.encode(newUser.getPassword()));
        User saved = userRepository.save(newUser);
        model.addAttribute("user", saved);
        return "signupResult";
    }

}
