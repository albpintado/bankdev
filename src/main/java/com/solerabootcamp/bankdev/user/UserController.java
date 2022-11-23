package com.solerabootcamp.bankdev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public String getOne() {
        return "Alberto";
    }

    @PostMapping()
    public String create() {
        return "Alberto";
    }

    @PutMapping()
    public String update(@RequestBody UpdateUserDto updateUserDto) {
        return this.service.update(updateUserDto);
    }

    @DeleteMapping()
    public String delete() {
        return "Deleted";
    }
}
