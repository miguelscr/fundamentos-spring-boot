package com.example.fundamentosspring.fundamentos.configuration;

import com.example.fundamentosspring.fundamentos.caseuse.GetUser;
import com.example.fundamentosspring.fundamentos.caseuse.GetUserImplement;
import com.example.fundamentosspring.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {

    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
