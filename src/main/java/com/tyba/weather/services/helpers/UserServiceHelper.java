package com.tyba.weather.services.helpers;

import com.tyba.weather.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;

final public class UserServiceHelper {

    private static List<GrantedAuthority> defaultAuthorities = Arrays.asList(new SimpleGrantedAuthority("user"));

    public static org.springframework.security.core.userdetails.User getSpringSecurityUser(final User user) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), defaultAuthorities);
    }

    private UserServiceHelper() {}
}
