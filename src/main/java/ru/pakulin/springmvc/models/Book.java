package ru.pakulin.springmvc.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @NotEmpty(message = "title name should not be empty")
    @Size(min = 2, max = 100, message = "The book title must be between 2 and 100 characters long")
    @Column(name = "book_title")
    private String title;

    @NotEmpty(message = "title name should not be empty")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters long")
    @Column(name = "book_author")
    private String author;

    @Min(value = 1564, message = "year should be greater then 1564")
    @Column(name = "book_publication_date")
    private int year;

    @JoinColumn(name = "person_id")
    @ManyToOne
    private Person reader;

}
