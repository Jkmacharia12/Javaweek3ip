package com.mash;

public class Animal {
    private int id;
    private String name;
    private String health;
    private String age;

    // Constructors
    public Animal() {
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;

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

}
