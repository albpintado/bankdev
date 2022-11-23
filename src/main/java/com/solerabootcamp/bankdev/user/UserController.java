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
    public User create(CreateUserDto createUserDto) {
        return this.service.create(createUserDto);
    }

    @PutMapping()
    public String update(@RequestBody UpdateUserDto updateUserDto) {
        return this.service.update(updateUserDto);
    }
}
