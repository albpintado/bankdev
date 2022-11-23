package com.solerabootcamp.bankdev.user;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Data {
    private Stream<User> users;

    private int count;

    private int userId = 0;

    public Data() {
        List<String> names = Arrays.asList("Solera", "Luis", "Miguel", "Pedro", "Juan", "Alejandro", "Andrea", "Paola", "Moises");
        Stream<String> streamNames = names.stream();

        Random random = new Random();
        String randomLastName = names.get(random.nextInt(names.size()));

        this.users = streamNames.map(name -> new User(userId++, name, randomLastName, name.toLowerCase(), "bootcamp4", name.toLowerCase() + "@solera.com", Math.floor(Math.random() * 1000000000) + "" ));
        this.count = names.size();
    }

    public Stream<User> getUsers() {
        return users;
    }

    public void setUsers(Stream<User> users) {
        this.users = users;
        this.count = (int) users.count();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
