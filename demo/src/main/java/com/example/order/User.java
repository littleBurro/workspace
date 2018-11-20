package com.example.order;

import java.util.Random;

public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt();
    }
}
