package com.msa4spring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    @GetMapping("/users")
    public String index() {
        return "GET Users";
    }

    @PostMapping("/users")
    public String store() {
        return "POST Users";
    }
}
