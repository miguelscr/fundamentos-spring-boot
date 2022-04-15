package com.example.fundamentosspring.fundamentos.Bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;
    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Este es un log info");
        System.out.println(myOperation.sum(5));
        LOGGER.debug("Este es un logger con debug ");
        System.out.println("Hola desde mi bean con una dependencia :D");
    }
}
