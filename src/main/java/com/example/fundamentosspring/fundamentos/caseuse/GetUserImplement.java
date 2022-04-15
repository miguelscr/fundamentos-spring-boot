package com.example.fundamentosspring.fundamentos.caseuse;

import com.example.fundamentosspring.fundamentos.entity.User;
import com.example.fundamentosspring.fundamentos.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
