package ru.iehtu.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import ru.iehtu.sfgdi.services.GreetingService;

@Controller
public class SetterInjectedController {

    
    private GreetingService greetingService;

    public GreetingService getGreetingService() {
        return greetingService;
    }

    @Qualifier("setterGreetingService")
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
