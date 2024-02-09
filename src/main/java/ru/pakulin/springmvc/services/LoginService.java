package ru.pakulin.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import ru.pakulin.springmvc.models.Person;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class LoginService {


    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    Map<String, String> userMap = new HashMap<>(Map.of("user", "password", "admin", "admin"));

    @Autowired
    public LoginService(AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    public Optional<Integer> login(Person person) {
        String password = userMap.get(person.getName());

        if (password != null && password.equals(person.getPassword())) {
            return Optional.of(1);
        }

        return Optional.empty();
    }

    public String signIn(Person person) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                person.getName(),
                person.getPassword()
        ));

        var person = userService
                .userDetailsService()
                .loadUserByUsername(person.getName());

        var jwt = jwtTokenService.generateToken(person);
        return new JwtAuthenticationResponse(jwt);
    }

}
