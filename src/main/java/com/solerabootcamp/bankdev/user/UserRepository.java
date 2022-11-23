package com.solerabootcamp.bankdev.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private Data users = new Data();

    public User getOne(int id) {
        User user = users.getUsers().filter(streamUser -> streamUser.getId() == id).findFirst().get();
        return user;
    }

    public String create() {
        return "Alberto";
    }

    public String update() {
        return "Alberto";
    }

    public String delete() {
        return "Deleted";
    }
}
