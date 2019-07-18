package com.tyba.weather.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author David Aldana
 * @since 2019.07
 */
@Data
@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
    private LocalDateTime signUpDate = LocalDateTime.now();
    @OneToMany(mappedBy = "user") private List<City> queriedCities;
}
