package ru.iehtu.sfgdi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.iehtu.sfgdi.controllers.ConstructorInjectedController;
import ru.iehtu.sfgdi.services.ConstructorGreetingService;

public class ConstructorInjectedControllerTest {
    
    ConstructorInjectedController controller;

    @Test
    void testName() {
        System.out.println(controller.getGreeting());
    }

    @BeforeEach
    void setUp() {
        
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
        
    }

}
