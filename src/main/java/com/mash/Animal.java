package com.mash;

public class Animal {
    private int id;
    private String name;
    private String health;
    private String age;

    // Constructors
    public Animal() {
    }

    public Animal(int id, String name, String health, String age) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.age = age;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
