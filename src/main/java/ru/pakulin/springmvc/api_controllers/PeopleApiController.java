package ru.pakulin.springmvc.api_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pakulin.springmvc.Services.PeopleService;
import ru.pakulin.springmvc.models.Person;

import java.util.List;

@RestController
@RequestMapping("/api/people/")
public class PeopleApiController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleApiController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getAllPersons() {
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.show(id);
    }
    @GetMapping("/age/{age}")
    public List<Person>  getPersonByAge(@PathVariable("age") int age) {
        return peopleService.findByAge(age);
    }
    @GetMapping("/name/{name}")
    public List<Person>  getPersonByName(@PathVariable("age") String name) {
        return peopleService.findByName(name);
    }
    @PostMapping()
    public Person create(@RequestBody Person person) {
        return peopleService.save(person);
    }


    @PutMapping("/{id}")
    public Person update(@PathVariable("id") int id,@RequestBody Person person) {
            return peopleService.update(id,person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        peopleService.delete(id);
    }
}
