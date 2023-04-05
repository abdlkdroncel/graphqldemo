package com.example.graphqldemo.controller;

import com.example.graphqldemo.model.UserRequest;
import com.example.graphqldemo.model.GraphqlUser;
import com.example.graphqldemo.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    List<GraphqlUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping
    GraphqlUser getUserById(@Argument Long id){
        return userService.getUserById(id);
    }

    @MutationMapping
    GraphqlUser createUser(@Argument UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @MutationMapping
    GraphqlUser updateUser(@Argument UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

    @MutationMapping
    Boolean deleteUser(@Argument Long id){
        return userService.deleteUser(id);
    }

}
