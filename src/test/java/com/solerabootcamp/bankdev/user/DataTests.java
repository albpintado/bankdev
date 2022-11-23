package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataTests {

    private final UserData userData = new UserData();

    @Test
    public void Data_WhenGetAfterCreation_ReturnsUsersAndThirdIsExpected() {
        List<User> users = this.userData.getUsers();
        int usersCount = this.userData.getCount();

        User firstUser = users.stream().filter(streamUser -> streamUser.getId() == 3).findFirst().get();

        assertEquals(9, usersCount);
        assertEquals(3, firstUser.getId());
        assertEquals("Pedro", firstUser.getUsername());
    }
}
