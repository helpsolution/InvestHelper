package com.investhelper.app.infrastructure.repository;

import com.investhelper.app.domain.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Long> {

    Optional<User> findByUsernameOrEmail(
            String username,
            String email
    );

    Optional<User> findByUsername(
            String username
    );

    Optional<User> findByEmail(
            String email
    );

}
