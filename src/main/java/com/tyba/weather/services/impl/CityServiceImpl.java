package com.tyba.weather.services.impl;

import com.tyba.weather.domain.City;
import com.tyba.weather.repository.CityRepository;
import com.tyba.weather.services.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author David Aldana
 * @since 2019.07
 */
@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public void saveCity(final City city) {
        cityRepository.save(city);
    }
}
