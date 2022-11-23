package com.solerabootcamp.bankdev.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping()
    public String update() {
        return "Alberto";
    }

    @DeleteMapping()
    public String delete() {
        return "Deleted";
    }
}