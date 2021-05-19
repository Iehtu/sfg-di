package ru.iehtu.sfgdi.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import ru.iehtu.sfgdi.services.GreetingService;

@Controller
public class ConstructorInjectedController {
    private GreetingService service;

    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService service) {
        this.service = service;
    }

    public String getGreeting(){
        return service.sayGreeting();
    }
}
