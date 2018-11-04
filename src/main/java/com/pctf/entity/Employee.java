package com.pctf.entity;

import com.pctf.annotation.*;

import java.util.Date;

@DBTable(name = "employee")
public class Employee {
    @SQLInteger(column = "id", constraints = @Constraints(primaryKey = true, unique = true, allowNull = false))
    private int id;

    @SQLString(column = "name", value = 50, constraints = @Constraints(allowNull = false))
    private String name;

    @SQLDate(column = "birth")
    private Date birth;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
