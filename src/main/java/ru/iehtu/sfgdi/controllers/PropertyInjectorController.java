package ru.iehtu.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import ru.iehtu.sfgdi.services.GreetingService;

@Controller
public class PropertyInjectorController {
    @Autowired
    @Qualifier("propertyGreetingService")
    public GreetingService greetingService;
    
    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
