package com.solerabootcamp.bankdev.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UserController {
    @GetMapping()
    public String getOne() {
        return "Alberto";
    }

    @PostMapping()
    public String create() {
        return "Alberto";
    }

    @DeleteMapping()
    public String delete() {
        return "Deleted";
    }
}
