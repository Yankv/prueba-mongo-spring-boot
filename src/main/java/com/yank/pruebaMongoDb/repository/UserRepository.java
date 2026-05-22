package com.yank.pruebaMongoDb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yank.pruebaMongoDb.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Find a user by its ID only if the user is active.
     * 
     * @param id The ID of the user to find.
     * @return Optional containing the user if found and active, or empty if not
     *         found or inactive.
     */
    Optional<User> findByIdAndActiveTrue(String id);

    /**
     * Find all users that are active.
     * 
     * @return List of active users.
     */
    List<User> findAllByActiveTrue();

    /**
     * Check whether an active user exists with the specified email.
     * 
     * @param email The email to check.
     * @return true if an active user exists with the email, otherwise false.
     */
    boolean existsByEmailAndActiveTrue(String email);

    /**
     * Find an active user by email.
     * 
     * @param email The email of the user to find.
     * @return Optional containing the active user if found, or empty if not found
     *         or inactive.
     */
    Optional<User> findByEmailAndActiveTrue(String email);
}
