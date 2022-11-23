package com.solerabootcamp.bankdev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public class UserService {

    @Autowired
    private UserRepository repo;

    public User getOne(int id) {
        User user = this.repo.getOne(id);
        return user;
    }

    public String create(User user) {
        this.repo.create(user);
        return "Created";
    }

    public String update(UpdateUserDto updateUserDto) {
        Stream<User> users = this.repo.getUsers().stream().map(user -> {
            if (user.getId() == updateUserDto.id) {
                user.setFirstName(updateUserDto.firstName);
                user.setLastName(updateUserDto.lastName);
                user.setEmail(updateUserDto.email);
                user.setPhone(updateUserDto.phone);
            }

            return user;
        });

        return this.repo.update(users);
    }
}
