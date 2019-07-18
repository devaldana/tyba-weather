package com.tyba.weather.services.impl;

import com.tyba.weather.domain.User;
import com.tyba.weather.services.UserService;
import com.tyba.weather.services.helpers.UserServiceHelper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service("tybaUserDeatailsService")
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = userService.findByUsername(username);
        if (isNull(user) ) throw new UsernameNotFoundException("Invalid user or password");
        return UserServiceHelper.getSpringSecurityUser(user);
    }
}