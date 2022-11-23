package com.solerabootcamp.bankdev.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTests {

    @InjectMocks
    private UserService service = new UserService();

    @Mock
    private UserRepository repo;

    @Test
    public void UserRepository_WhenCreate_ReturnsUserCreated() {
        CreateUserDto createUserDto = new CreateUserDto();
        createUserDto.firstName = "Isabel";
        createUserDto.lastName = "Lozano";
        createUserDto.username = "isabel";
        createUserDto.password = "A12345678!";

        Mockito.when(this.repo.getDataCount()).thenReturn(9);

        User userToSave = new User(9, createUserDto.firstName, createUserDto.lastName, createUserDto.username, createUserDto.password, "", "");
        User actualUser = this.service.create(createUserDto);

        assertThat(userToSave).usingRecursiveComparison().isEqualTo(actualUser);
    }
}
