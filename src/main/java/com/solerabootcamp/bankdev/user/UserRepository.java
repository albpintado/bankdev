package com.solerabootcamp.bankdev.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class UserRepository {

    private UserData users;

    public UserRepository() {
        this.users =  new UserData();
    }

    public List<User> getUsers() {
        return this.users.getUsers();
    }

    public User getOne(int id) {
        User user = this.users.getUsers().stream().filter(streamUser -> streamUser.getId() == id).findFirst().get();
        return user;
    }

    public int getDataCount() {
        return this.users.getCount();
    }

    public String create(User user) {
        this.users.setUsers(Stream.concat(this.users.getUsers().stream(), Stream.of(user)).toList());
        return "Created";
    }

    public String update(Stream<User> users) {
        this.users.setUsers(users.toList());
        return "Updated";
    }

    public String delete(int id) {
        Stream<User> newUsers = this.users.getUsers().stream().filter(user -> user.getId() != id);
        this.users.setUsers(newUsers.toList());
        return "Deleted";
    }
}
