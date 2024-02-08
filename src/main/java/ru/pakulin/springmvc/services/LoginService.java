package ru.pakulin.springmvc.services;

import org.springframework.stereotype.Service;
import ru.pakulin.springmvc.models.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class LoginService {



    Map<String, String> userMap = new HashMap<>(Map.of("user", "password", "admin", "admin"));

    public Optional<Integer> login(Person person) {
        String password = userMap.get(person.getName());

        if (password != null && password.equals(person.getPassword())) {
            return Optional.of(1);
        }

        return Optional.empty();
    }

}
