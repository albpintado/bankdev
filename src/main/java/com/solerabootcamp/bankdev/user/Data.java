package com.solerabootcamp.bankdev.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Data {
    private List<User> users;

    private int id = 0;

    public Data() {
        List<String> names = Arrays.asList("Alberto", "Luis", "Miguel", "Pedro", "Juan", "Alejandro", "Andrea", "Paola", "Moises");
        Stream<String> streamNames = names.stream();

        Random random = new Random();
        String randomLastName = names.get(random.nextInt(names.size()));

        List<User> users = new ArrayList<>();
        streamNames.forEach(name -> {
            users.add(new User(id++, name, randomLastName, name, "A12345678!", name.toLowerCase() + "@gmail.com", Math.floor(Math.random() * 1000000000) + "" ));
        });

        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
