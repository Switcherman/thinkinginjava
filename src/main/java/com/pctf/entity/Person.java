package com.pctf.entity;

import com.pctf.annotation.UseCase;

@UseCase(id = 1, description = "to define a person")
public class Person {

    public int id;

    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
