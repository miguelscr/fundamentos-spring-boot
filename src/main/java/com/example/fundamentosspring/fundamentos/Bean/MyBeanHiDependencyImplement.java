package com.example.fundamentosspring.fundamentos.Bean;

public class MyBeanHiDependencyImplement implements MyBeanHiDependency{

    MyHi myHi;

    public MyBeanHiDependencyImplement(MyHi myHi) {
        this.myHi = myHi;
    }

    @Override
    public void sayHi() {
        System.out.println(myHi.hi("Wendy") + ", how's it going?");
    }
}
