package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

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
    public void UserRepository_WhenGetDataCount_ReturnsDataCount() {
        int dataCount = this.repo.getDataCount();

        assertEquals(9, dataCount);
    }

    @Test
    public void UserRepository_WhenCreate_ReturnsCreatedMessage() {
        User user = new User(10, "Jose", "Perez", "jose", "A12345678!", "jose".toLowerCase() + "@gmail.com", Math.floor(Math.random() * 1000000000) + "" );
        String userNameCreatedResponse = this.repo.create(user);
        int dataCount = this.repo.getDataCount();

        assertEquals("Created", userNameCreatedResponse);
        assertEquals(10, dataCount);
    }

    @Test
    public void UserRepository_WhenUpdate_ReturnsNewUserName() {
        UpdateUserDto userDto = new UpdateUserDto();
        userDto.id = 0;
        userDto.firstName = "Nuevo";
        userDto.lastName = "Nuevo";
        userDto.email = "Nuevo";
        userDto.phone = "Nuevo";

        Stream<User> users = this.repo.getUsers().stream().map(user -> {
            if (user.getId() == userDto.id) {
                user.setFirstName(userDto.firstName);
                user.setLastName(userDto.lastName);
                user.setEmail(userDto.email);
                user.setPhone(userDto.phone);
            }

            return user;
        });

        String updateMessage = this.repo.update(users);

        assertEquals("Updated", updateMessage);
    }

    @Test
    public void UserRepository_WhenDelete_ReturnsDeletedMessageAndNewDataCount() {
        String userNameReturned = this.repo.delete(0);
        int dataCount = this.repo.getDataCount();


        assertEquals("Deleted", userNameReturned);
        assertEquals(8, dataCount);
    }
}
