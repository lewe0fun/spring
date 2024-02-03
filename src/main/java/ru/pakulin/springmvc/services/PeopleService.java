package ru.pakulin.springmvc.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person show(int id) {
        Optional<Person> optionalPerson = peopleRepository.findById(id);
        return optionalPerson.orElseThrow(()->new RuntimeException("Person not found"));
    }

    public List<Person> findByAge(int age) {
        return peopleRepository.findByAge(age);
    }
    public List<Person> findByName(String name) {
        return peopleRepository.findByName(name);
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
