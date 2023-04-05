package com.example.graphqldemo.service;

import com.example.graphqldemo.model.UserRequest;
import com.example.graphqldemo.model.GraphqlUser;
import com.example.graphqldemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<GraphqlUser> getAllUsers() {
        return userRepository.findAll();
    }

    public GraphqlUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new ResolutionException("user not found"));
    }

    public GraphqlUser createUser(UserRequest userRequest) {
        GraphqlUser user= GraphqlUser.builder().username(userRequest.getUsername())
                .mail(userRequest.getMail()).role(userRequest.getRole()).build();
        return userRepository.save(user);
    }

    public GraphqlUser updateUser(UserRequest userRequest) {
        GraphqlUser exist=getUserById(userRequest.getId());
        exist.setRole(userRequest.getRole());
        exist.setUsername(userRequest.getUsername());
        exist.setMail(userRequest.getMail());
        return userRepository.save(exist);
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
