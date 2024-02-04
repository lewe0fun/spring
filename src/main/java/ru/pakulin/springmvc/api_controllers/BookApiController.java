package ru.pakulin.springmvc.api_controllers;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pakulin.springmvc.models.Book;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.services.BookService;
import ru.pakulin.springmvc.services.PeopleService;

import java.util.List;

@RestController
@RequestMapping("/api/books/")
@Tag(name = "BOOKS API")
public class BookApiController {
    @Autowired
    private BookService bookService;

    @Autowired
    private PeopleService readerService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable @Parameter(description = "Book id", example = "1") int id) {
        System.out.println(bookService.findById(id).getReader());
        return bookService.findById(id);
    }

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}/reader/{readerId}")
    public Book assignReaderToBook(@PathVariable int id, @PathVariable int readerId) {
        return bookService.assign(id, readerId);
    }

    @PutMapping("/{id}")
    public Book releaseBook(@PathVariable int id) {
        return bookService.release(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.delete(id);
    }

    @GetMapping("/readers")
    public List<Person> getAllReaders() {
        return readerService.findAll();
    }

    @PostMapping("/readers")
    public Person addReader(@RequestBody Person reader) {
        return readerService.save(reader);
    }

    @GetMapping("/readers/{id}")
    public List<Book> getAllBooksOfReader(@PathVariable int id) {
        return bookService.findBooksByPerson(id);
    }
}
