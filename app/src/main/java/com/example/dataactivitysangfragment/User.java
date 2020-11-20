package com.example.dataactivitysangfragment;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;
    private String adress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public User(String name, int age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }
}
