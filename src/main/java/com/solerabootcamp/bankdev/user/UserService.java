package com.solerabootcamp.bankdev.user;

import com.solerabootcamp.bankdev.bankaccount.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserService {

    @Autowired
    private UserRepository repo;

    public User getOne(GetUserDto getUserDto) {
        User user = this.repo.getOne(getUserDto.id);
        return user;
    }

    public User create(CreateUserDto createUserDto) {
        int newId = this.repo.getDataCount();
        User userToSave = new User(newId, createUserDto.firstName, createUserDto.lastName, createUserDto.username, createUserDto.password, "", "");

        this.repo.create(userToSave);
        return userToSave;
    }

    public boolean login() {
        return true;
    }

    public User update(UpdateUserDto updateUserDto) {
        Stream<User> users = this.repo.getUsers().stream().map(user -> {
            List<Integer> userBankAccounts = Stream.concat(user.getBankAccounts().stream(), Stream.of(updateUserDto.bankAccountId)).toList();
            if (user.getId() == updateUserDto.id) {
                user.setBankAccounts(userBankAccounts);
                user.setFirstName(updateUserDto.firstName);
                user.setLastName(updateUserDto.lastName);
                user.setEmail(updateUserDto.email);
                user.setPhone(updateUserDto.phone);
            }

            return user;
        });

        this.repo.update(users);
        return this.repo.getOne(updateUserDto.id);
    }
}
