package com.example.fundamentosspring.fundamentos.configuration;

import com.example.fundamentosspring.fundamentos.Bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public MyMessenge beanOperationMessenge(){
        return new MyMessengeImplement();
    }

    @Bean
    public MyBeanNewDependency beanOperationNewDependency(MyMessenge myMessenge){
        return new MyBeanNewDependencyImplement(myMessenge);
    }

    @Bean
    public MyHi beanOperationHi(){
        return new MyHiImplement();
    }

    @Bean
    public MyBeanHiDependency beanOperationHiDependency(MyHi myHi){
        return new MyBeanHiDependencyImplement(myHi);
    }
}
