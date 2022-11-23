package com.solerabootcamp.bankdev.user;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public class UserRepository {

    private Data users;

    public UserRepository() {
        this.users =  new Data();
    }

    public User getOne(int id) {
        User user = users.getUsers().filter(streamUser -> streamUser.getId() == id).findFirst().get();
        return user;
    }

    public int getDataCount() {
        return this.users.getCount();
    }

    public String create(User user) {
        this.users.setUsers(Stream.concat(this.users.getUsers(), Stream.of(user)));
        this.users.setCount(this.users.getCount() + 1);
        return "Created";
    }

    public String update() {
        return "Alberto";
    }

    public String delete() {
        return "Deleted";
    }
}
