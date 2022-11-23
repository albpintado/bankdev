package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService service;

    @Test
    public void UserService_WhenGET_ReturnsUserNameAsString() {
        String userNameReturned = this.service.getOne();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserService_WhenPOST_ReturnsUserNameAsString() {
        String userNameReturned = this.service.create();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserService_WhenPUT_ReturnsNewUserNameAsString() {
        String userNameReturned = this.service.update();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserService_WhenDELETE_ReturnsAString() {
        String userNameReturned = this.service.delete();

        assertEquals("Deleted", userNameReturned);
    }
}
