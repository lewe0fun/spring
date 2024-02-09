package ru.pakulin.springmvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.pakulin.springmvc.services.BookService;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @JoinColumn(name = "books")
    @OneToMany
    private List<Book> books;

    public void setId(int id) {
        this.person_id=id;
    }
}
