package ru.pakulin.springmvc.config.dao;

import org.springframework.stereotype.Component;
import ru.pakulin.springmvc.config.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Nom"));
        people.add(new Person(++PEOPLE_COUNT, "Duke"));
        people.add(new Person(++PEOPLE_COUNT, "Max"));
        people.add(new Person(++PEOPLE_COUNT, "Vano"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }
}