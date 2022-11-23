package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Test
    public void UserRepository_WhenGET_ReturnsUserNameAsString() {
        String userNameReturned = this.repo.getOne(1).getUsername();

        assertEquals("Luis", userNameReturned);
    }

    @Test
    public void UserRepository_WhenPOST_ReturnsUserNameAsString() {
        String userNameReturned = this.repo.create();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserRepository_WhenPUT_ReturnsNewUserNameAsString() {
        String userNameReturned = this.repo.update();

        assertEquals("Alberto", userNameReturned);
    }

    @Test
    public void UserRepository_WhenDELETE_ReturnsAString() {
        String userNameReturned = this.repo.delete();

        assertEquals("Deleted", userNameReturned);
    }
}
