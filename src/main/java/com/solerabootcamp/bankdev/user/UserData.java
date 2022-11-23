package com.solerabootcamp.bankdev.user;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Data {
    private List<User> users;

    private int count;

    private int userId = 0;

    public Data() {
        List<String> names = Arrays.asList("Solera", "Luis", "Miguel", "Pedro", "Juan", "Alejandro", "Andrea", "Paola", "Moises");
        Stream<String> streamNames = names.stream();

        Random random = new Random();
        String randomLastName = names.get(random.nextInt(names.size()));

        this.users = streamNames.map(name -> new User(userId++, name, randomLastName, name.toLowerCase(), "bootcamp4", name.toLowerCase() + "@solera.com", Math.floor(Math.random() * 1000000000) + "" )).toList();
        this.count = names.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        this.count = (int) users.size();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
