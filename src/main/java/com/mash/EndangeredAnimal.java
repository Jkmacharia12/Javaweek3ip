package com.mash;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal {
    public String name;
    public int id;
    public boolean endangered;
    private String health;
    private String age;

    public EndangeredAnimal(String name) {
        this.name = name;
        this.id = id;
        this.health = health;
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherEndangeredAnimal) {
        if(!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return this.getName().equals(newEndangeredAnimal.getName());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered_animals (name) VALUES (:name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<EndangeredAnimal> all() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals;";
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals WHERE id=:id;";
            EndangeredAnimal endangeredAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return endangeredAnimal;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public void update(String health, String age) {
        try(Connection con = DB.sql2o.open()) {
            String updateHealth = "UPDATE endangered_animals SET health=:health WHERE id=:id;";
            String updateAge = "UPDATE endangered_animals SET age=:age WHERE id=:id;";
            con.createQuery(updateHealth)
                    .addParameter("id", id)
                    .addParameter("health", health)
                    .executeUpdate();
            con.createQuery(updateAge)
                    .addParameter("age", age)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public List<Sighting> getSightings() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animal_id = :id;";
            List<Sighting> sightings = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Sighting.class);
            return sightings;
        }
    }
}