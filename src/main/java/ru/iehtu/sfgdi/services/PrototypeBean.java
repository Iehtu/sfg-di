package ru.iehtu.sfgdi.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class PrototypeBean {

    public PrototypeBean() {
        
        System.out.println("Creating a Prototype bean !!!");
    
    }

    public String getMyScope(){
        return "I'm a Prototype";
    }
}
