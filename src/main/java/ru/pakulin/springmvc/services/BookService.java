package ru.pakulin.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pakulin.springmvc.annotations.LogException;
import ru.pakulin.springmvc.annotations.LoggedExecution;
import ru.pakulin.springmvc.models.Book;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PeopleService readerService;

    @Transactional
    public Book update(int id, Book book) {
        Book existingBook = findById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);
    }
    @LoggedExecution
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    @LoggedExecution
    @LogException
    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new RuntimeException("book not found"));
    }
    @LoggedExecution
    public List<Book> findBooksByPerson(int id) {
        return bookRepository.findBooksByPerson(id);
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book assign(int book_id, int readerId) {
        Book existingBook = findById(book_id);
        Person reader = readerService.findById(readerId);
        existingBook.setReader(reader);
        return bookRepository.save(existingBook);
    }

    @Transactional
    public Book release(int id) {
        Book existingBook = findById(id);
        existingBook.setReader(null);
        return bookRepository.save(existingBook);
    }
}
