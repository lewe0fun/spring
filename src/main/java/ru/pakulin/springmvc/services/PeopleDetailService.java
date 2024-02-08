package ru.pakulin.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.repositories.PeopleRepository;

public class PeopleDetailService implements UserDetailsService {


    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Person person = peopleRepository.findByName(username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(person);
    }
}
