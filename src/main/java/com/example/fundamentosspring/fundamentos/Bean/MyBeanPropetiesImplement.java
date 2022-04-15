package com.example.fundamentosspring.fundamentos.Bean;

public class MyBeanPropetiesImplement implements MyBeanPropeties{
    private String name, lastName;

    public MyBeanPropetiesImplement(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String showMe() {
        return name + " " + lastName;
    }
}
