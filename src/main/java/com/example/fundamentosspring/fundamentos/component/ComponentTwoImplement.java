package com.example.fundamentosspring.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi segunda implementación :D");
    }
}
