package com.jdbc.entity;

public class User {
    private String Name;
    private String Sex;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Sex='" + Sex + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public User(String name, String sex) {
        Name = name;
        Sex = sex;
    }


}
