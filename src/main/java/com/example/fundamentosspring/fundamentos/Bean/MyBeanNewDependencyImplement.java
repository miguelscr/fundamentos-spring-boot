package com.example.fundamentosspring.fundamentos.Bean;

public class MyBeanNewDependencyImplement implements MyBeanNewDependency{
    MyMessenge myMessenge;

    public MyBeanNewDependencyImplement(MyMessenge myMessenge) {
        this.myMessenge = myMessenge;
    }

    @Override
    public void showIt() {
        System.out.println(myMessenge.saludaPersona("Wendy"));
    }
}
