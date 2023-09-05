package ru.pakulin.springmvc.config.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.pakulin.springmvc.config.dao.PersonDAO;
import ru.pakulin.springmvc.config.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person")
                             @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "people/new";
        }
        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id,BindingResult bindingResult) {
        if(bindingResult.hasErrors())return "people/edit";
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person")Person person,
                         @PathVariable("id")int id){
        personDAO.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}/delete")
    String delete(@PathVariable("id")int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
