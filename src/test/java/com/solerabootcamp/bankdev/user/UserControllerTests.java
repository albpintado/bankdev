package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BankAccountControllerTests {

    @InjectMocks
    private UserController controller = new UserController();

    @Mock
    private UserService service;

    @Test
    public void UserController_WhenGET_ReturnsUserNameAsString() {
        GetUserDto getUserDto = new GetUserDto();
        getUserDto.id = 1;
        User expectedUser = new User(1, "Luis", "Pintado", "luis", "A12345678!", "", "");

        Mockito.when(this.service.getOne(getUserDto)).thenReturn(expectedUser);

        User actualUser = this.controller.getOne(getUserDto);

        assertEquals(expectedUser, actualUser);
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
