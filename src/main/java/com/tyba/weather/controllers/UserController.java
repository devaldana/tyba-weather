package com.tyba.weather.controllers;

import com.tyba.weather.domain.City;
import com.tyba.weather.domain.User;
import com.tyba.weather.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody final User user){
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{username}")
    public ResponseEntity<List<City>> queriedCities(@PathVariable String username) {
        List<City> queriedCities = userService.findByUsername(username).getQueriedCities();
        return ResponseEntity.ok(queriedCities);
    }
}
