package ru.pakulin.springmvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pakulin.springmvc.services.BookService;

import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 32, message = "too long name")
    @Column(name = "person_name")
    private String name;
    @Min(value = 0, message = "should be greater then 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "name should not be empty")
    @Email(message = "email isn't valid")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "pass should not be empty")
    @Column(name = "password")
    private String password;

    @JoinColumn(name = "books")
    @OneToMany
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person() {
    }

    public int getId() {
        return person_id;
    }

    public void setId(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + person_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
