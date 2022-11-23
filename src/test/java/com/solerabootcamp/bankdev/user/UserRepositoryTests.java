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
    public void UserRepository_WhenGetOne_ReturnsUserNameAsString() {
        String userNameReturned = this.repo.getOne(1).getUsername();

        assertEquals("Luis", userNameReturned);
    }

    @Test
    public void UserRepository_WhenGetDataCount_Returns9() {
        int dataCount = this.repo.getDataCount();

        assertEquals(9, dataCount);
    }

    @Test
    public void UserRepository_WhenPOST_ReturnsUserNameAsString() {
        User user = new User(10, "Jose", "Perez", "jose", "A12345678!", "jose".toLowerCase() + "@gmail.com", Math.floor(Math.random() * 1000000000) + "" );
        String userNameCreatedResponse = this.repo.create(user);
        int dataCount = this.repo.getDataCount();

        assertEquals("Created", userNameCreatedResponse);
        assertEquals(10, dataCount);
    }

    @Test
    public void UserRepository_WhenPUT_ReturnsNewUserNameAsString() {
        String userNameReturned = this.repo.update(0, "Luis");

        assertEquals("Luis", userNameReturned);
    }

    @Test
    public void UserRepository_WhenDELETE_ReturnsAString() {
        String userNameReturned = this.repo.delete();

        assertEquals("Deleted", userNameReturned);
    }
}
