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
        String userNameReturned = this.controller.create();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserController_WhenPUT_ReturnsNewUserNameAsString() {
        UpdateUserDto userDto = new UpdateUserDto();
        userDto.id = 1;
        userDto.firstName = "Nuevo";
        userDto.lastName = "Nuevo";
        userDto.email = "Nuevo";
        userDto.phone = "Nuevo";

        String updateMessage = this.controller.update(userDto);

        assertEquals("Updated", updateMessage);
    }

    @Test
    public void UserController_WhenDELETE_ReturnsAString() {
        String userNameReturned = this.controller.delete();

        assertEquals("Deleted", userNameReturned);
    }
}
