package ru.pakulin.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pakulin.springmvc.models.Book;

import java.util.List;
@Repository

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT book.person_id, book.book_id, book.book_author, book.book_title, book.book_publication_date " +
            "FROM book JOIN person ON book.person_id = person.person_id WHERE person.person_id =?",nativeQuery = true)
    List<Book> findBooksByPerson(int personId);
}
