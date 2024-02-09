package ru.pakulin.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.pakulin.springmvc.configs.MyUserDetails;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.repositories.PeopleRepository;

@Service
public class PeopleDetailService implements UserDetailsService {


    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Person person = peopleRepository.findByName(username);
        if (person == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(person);
    }
}
