package com.example.fundamentosspring.fundamentos.Bean;

public class MyHiImplement implements MyHi{
    @Override
    public String hi(String name) {
        return "Hello " + name;
    }
}
