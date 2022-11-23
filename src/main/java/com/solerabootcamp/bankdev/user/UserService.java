package com.solerabootcamp.bankdev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public String update(int id, String newName) {
        return this.repo.update(id, newName);
    }

    public String delete() {
        return "Deleted";
    }
}
