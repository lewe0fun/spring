package ru.pakulin.springmvc.api_controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pakulin.springmvc.models.Person;
import ru.pakulin.springmvc.services.JwtTokenService;
import ru.pakulin.springmvc.services.LoginService;

@RestController()
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenService jwtTokenService;
    private final LoginService loginService;

    @Autowired
    public AuthController(JwtTokenService jwtTokenService, LoginService loginService) {
        this.jwtTokenService = jwtTokenService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Person person) {
        return loginService.login(person)
                .map(userId -> {
                    String token = jwtTokenService.generateToken(userId, "USER");
                    return new ResponseEntity<>("Bearer " + token, HttpStatus.OK);
                }).orElseGet(() -> new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
    }

}
