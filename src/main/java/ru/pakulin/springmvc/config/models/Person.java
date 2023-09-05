package ru.pakulin.springmvc.config.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2,max = 32,message = "too long name")
    private String name;
    @Min(value = 0,message = "should be greater then 0")
    private  int age;
    @NotEmpty(message = "name should not be empty")
    @Email(message = "email isn't valid")
    private String email;

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age=age;
        this.email=email;
    }

    public Person() {
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
