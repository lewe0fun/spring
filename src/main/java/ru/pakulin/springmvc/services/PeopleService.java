package ru.pakulin.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findById(int id) {
        Optional<Person> optionalPerson = peopleRepository.findById(id);
        return optionalPerson.orElseThrow(() -> new RuntimeException("Person not found"));
    }


    public List<Person> findByAge(int age) {
        return peopleRepository.findByAge(age);
    }

    public List<Person> findByName(String name) {
        return peopleRepository.findUsersByName(name);
    }

    public List<Person> findByAgeMoreThen(int age) {
        return peopleRepository.findByAgeMoreThen(age);
    }

    public List<Person> findByAgeLessThen(int age) {
        return peopleRepository.findByAgeLessThen(age);
    }
    public boolean existsByName(String name){
        return peopleRepository.existsByName(name);
    }
    public boolean existsByEmail(String email){
        return peopleRepository.existsByEmail(email);
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
