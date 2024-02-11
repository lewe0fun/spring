package ru.pakulin.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.pakulin.springmvc.annotations.LogException;
import ru.pakulin.springmvc.annotations.LoggedExecution;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    @LoggedExecution
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @LoggedExecution
    @LogException
    public Person findById(int id) {
        Optional<Person> optionalPerson = peopleRepository.findById(id);
        return optionalPerson.orElseThrow(() -> new RuntimeException("Person not found"));
    }
    @LoggedExecution
    public List<Person> findByAge(int age) {
        return peopleRepository.findByAge(age);
    }
    @LoggedExecution
    public List<Person> findByName(String name) {
        return peopleRepository.findByName(name);
    }
    @LoggedExecution
    public List<Person> findByAgeMoreThen(int age) {
        return peopleRepository.findByAgeMoreThen(age);
    }
    @LoggedExecution
    public List<Person> findByAgeLessThen(int age) {
        return peopleRepository.findByAgeLessThen(age);
    }

    @Transactional
    public Person save(Person person) {
        return peopleRepository.save(person);
    }

    @Transactional
    public Person update(int id, Person person) {
        person.setId(id);
        return peopleRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }


}
