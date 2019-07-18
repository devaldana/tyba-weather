package com.tyba.weather.services;

import com.tyba.weather.domain.User;

/**
 * @author David Aldana
 * @since 2019.07
 */
public interface UserService {
    User findByUsername(String username);
    void register(User user);
}
