package ru.pakulin.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pakulin.springmvc.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
    @Query(value = "SELECT * FROM person WHERE age=?",nativeQuery = true)
    List<Person> findByAge(int age);

    @Query(value = "SELECT * FROM person WHERE name=?",nativeQuery = true)
    List<Person> findUsersByName(String name);

    @Query(value = "SELECT * FROM person WHERE age > ?",nativeQuery = true)
    List<Person> findByAgeMoreThen(int age);

    @Query(value = "SELECT * FROM person WHERE age < ?",nativeQuery = true)
    List<Person> findByAgeLessThen(int age);
    Person findByName(String name);
}
