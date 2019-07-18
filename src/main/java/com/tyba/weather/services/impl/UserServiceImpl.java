package com.tyba.weather.services.impl;

import com.tyba.weather.domain.User;
import com.tyba.weather.repository.UserRepository;
import com.tyba.weather.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author David Aldana
 * @since 2019.07
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void register(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
