package com.services.app.infra.repository;

import com.services.app.infra.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * @author Ashwani Pandey
 * @created 22/02/2022
 */
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
