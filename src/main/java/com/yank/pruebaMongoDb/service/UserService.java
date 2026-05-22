package com.yank.pruebaMongoDb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yank.pruebaMongoDb.dto.request.UserRequest;
import com.yank.pruebaMongoDb.dto.response.UserResponse;
import com.yank.pruebaMongoDb.exception.BusinessException;
import com.yank.pruebaMongoDb.exception.ResourceNotFoundException;
import com.yank.pruebaMongoDb.mapper.UserMapper;
import com.yank.pruebaMongoDb.model.User;
import com.yank.pruebaMongoDb.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository repository;

    @Override
    public UserResponse createUser(UserRequest request) {
        if (repository.existsByEmailAndActiveTrue(request.getEmail())) {
            throw new BusinessException("Email already exists: " + request.getEmail());
        }

        return UserMapper.toResponse(
                repository.save(UserMapper.toEntity(request)));
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = repository.findAllByActiveTrue();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }
        return UserMapper.toResponseList(users);
    }

    @Override
    public UserResponse findById(String id) {
        return UserMapper.toResponse(
                repository.findByIdAndActiveTrue(id).orElseThrow(
                        () -> new ResourceNotFoundException("No user found with ID: " + id)));
    }

    @Override
    public UserResponse update(String id, UserRequest request) {
        User user = repository.findByIdAndActiveTrue(id).orElseThrow(
                () -> new ResourceNotFoundException("No user found with ID: " + id));

        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setAddress(UserMapper.toAddressEntity(request.getAddress()));

        User updatedUser = repository.save(user);

        return UserMapper.toResponse(updatedUser);
    }

    @Override
    public void delete(String id) {
        User user = repository.findByIdAndActiveTrue(id).orElseThrow(
                () -> new ResourceNotFoundException("No user found with ID: " + id));

        user.setActive(false);

        repository.save(user);
    }

}
