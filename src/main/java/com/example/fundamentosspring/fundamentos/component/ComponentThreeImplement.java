package com.example.fundamentosspring.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentThreeImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi tercera implementación, I'm learning :D");
    }
}
