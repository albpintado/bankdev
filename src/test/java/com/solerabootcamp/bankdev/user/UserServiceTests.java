package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @InjectMocks
    private UserService service = new UserService();

    @Mock
    private UserRepository repo;

    @Test
    public void UserRepository_WhenCreate_ReturnsCreatedMessage() {
        User user = new User(10, "Jose", "Perez", "jose", "A12345678!", "jose".toLowerCase() + "@gmail.com", Math.floor(Math.random() * 1000000000) + "" );
        String userNameCreatedResponse = this.service.create(user);

        assertEquals("Created", userNameCreatedResponse);
    }

    @Test
    public void UserRepository_WhenDelete_ReturnsDeletedMessageAndCurrentDataCount() {
        String userNameReturned = this.repo.delete(0);
        int dataCount = this.repo.getDataCount();

        assertEquals("Deleted", userNameReturned);
        assertEquals(8, dataCount);
    }
}
