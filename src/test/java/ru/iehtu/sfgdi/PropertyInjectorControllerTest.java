package ru.iehtu.sfgdi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.iehtu.sfgdi.controllers.PropertyInjectorController;
import ru.iehtu.sfgdi.services.ConstructorGreetingService;

public class PropertyInjectorControllerTest {
    
    PropertyInjectorController controller;
    
    @BeforeEach
    void setUp() {
        controller = new PropertyInjectorController();
        controller.greetingService = new ConstructorGreetingService();
    }

    @Test
    void getGreeting(){

        System.out.println(controller.getGreeting());

    }
}
