package ru.pakulin.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pakulin.springmvc.models.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
}
