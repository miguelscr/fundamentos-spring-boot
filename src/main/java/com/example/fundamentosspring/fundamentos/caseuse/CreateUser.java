package com.example.fundamentosspring.fundamentos.caseuse;

import com.example.fundamentosspring.fundamentos.entity.User;
import com.example.fundamentosspring.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
