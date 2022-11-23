package com.solerabootcamp.bankdev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public User getOne(@RequestBody GetUserDto getUserDto) {
        return this.service.getOne(getUserDto);
    }

    @PostMapping()
    public User create(@RequestBody CreateUserDto createUserDto) {
        return this.service.create(createUserDto);
    }

    @PutMapping()
    public User update(@RequestBody UpdateUserDto updateUserDto) {
        return this.service.update(updateUserDto);
    }
}
