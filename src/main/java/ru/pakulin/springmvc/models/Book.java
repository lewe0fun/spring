package ru.pakulin.springmvc.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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

/*    public Book() {
    }

    public Book(String title, String author, int year, Person reader) {
        this.title = title;
        this.author = author;
        this.reader = reader;
    }*/

    public int getId() {
        return book_id;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public Person getReader() {
        return reader;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }
}
