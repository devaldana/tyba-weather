package com.tyba.weather.services.impl;

import com.tyba.weather.services.WeatherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author David Aldana
 * @since 2019.07
 */
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    @Value("${tyba.services.weather.api-url}")
    private String weatherApiUrl;
    private final RestTemplate restTemplate;

    public String weatherByCity(final String city) {
        final String url = weatherApiUrl + "&q=" + city;
        return restTemplate.getForObject(url , String.class);
    }
}
