package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DataTests {

    private final Data data = new Data();

    @Test
    public void Data_WhenGetAfterCreation_ReturnsUsersAndThirdIsExpected() {
        List<User> users = this.data.getUsers();

        User firstUser = users.get(3);

        assertEquals(9, users.size());
        assertEquals(3, firstUser.getId());
        assertEquals("Pedro", firstUser.getUsername());
    }
}
