package com.tyba.weather.repository;

import com.tyba.weather.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author David Aldana
 * @since 2019.07
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String username);
}
