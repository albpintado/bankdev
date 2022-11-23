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
        return "Created";
    }

    public String update(int id, String newName) {
        User user = getOne(id);
        user.setFirstName(newName);
        return user.getFirstName();
    }

    public String delete(int id) {
        Stream<User> newUsers = this.users.getUsers().filter(user -> user.getId() != id);
        this.users.setUsers(newUsers);
        return "Deleted";
    }
}
