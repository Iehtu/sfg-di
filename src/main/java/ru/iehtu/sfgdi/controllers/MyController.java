package ru.iehtu.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import ru.iehtu.sfgdi.services.GreetingService;

@Controller
public class MyController {
    
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        System.out.println(greetingService.sayGreeting());
        return "Hi, Folks!";
    }

}
