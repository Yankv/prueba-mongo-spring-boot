package com.yank.pruebaMongoDb.service;

import java.util.List;

import com.yank.pruebaMongoDb.dto.request.UserRequest;
import com.yank.pruebaMongoDb.dto.response.UserResponse;

public interface IUserService {
    /**
     * Create a new user.
     * 
     * @param request User creation request data.
     * @return Created user response.
     */
    UserResponse createUser(UserRequest request);

    /**
     * Retrieve all active users.
     * 
     * @return List of user responses.
     */
    List<UserResponse> findAll();

    /**
     * Retrieve a user by ID.
     * 
     * @param id User identifier.
     * @return User response.
     */
    UserResponse findById(String id);

    /**
     * Update an existing user.
     * 
     * @param id      User identifier.
     * @param request User update request data.
     * @return Updated user response.
     */
    UserResponse update(String id, UserRequest request);

    /**
     * Delete a user by ID.
     * 
     * @param id User identifier.
     */
    void delete(String id);
}
