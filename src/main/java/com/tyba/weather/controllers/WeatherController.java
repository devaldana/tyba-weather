package com.tyba.weather.controllers;

import com.tyba.weather.domain.City;
import com.tyba.weather.domain.User;
import com.tyba.weather.services.CityService;
import com.tyba.weather.services.UserService;
import com.tyba.weather.services.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final CityService cityService;
    private final UserService userService;

    @GetMapping
    public String weatherByCity(@RequestParam("city") String city, final Principal principal) {
        User currentUser = userService.findByUsername(principal.getName());
        City queriedCity = new City();
        queriedCity.setName(city.toUpperCase());
        queriedCity.setUser(currentUser);
        cityService.saveCity(queriedCity);
        return weatherService.weatherByCity(city);
    }
}
