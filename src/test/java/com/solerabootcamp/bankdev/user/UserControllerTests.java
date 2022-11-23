package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTests {

    @Autowired
    private UserController controller;

    @Test
    public void UserController_WhenGET_ReturnsUserNameAsString() {
        String userNameReturned = this.controller.getOne();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserController_WhenPOST_ReturnsUserNameAsString() {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.firstName = "Isabel";
        createUserDto.lastName = "Lozano";
        createUserDto.username = "isabel";
        createUserDto.password = "A12345678!";
        User actualUser = this.controller.create(createUserDto);

        User expectedUser = new User(10, "Isabel", "Lozano", "isabel", "A12345678!", "", "");

        assertEquals(expectedUser, actualUser);
    }
}
