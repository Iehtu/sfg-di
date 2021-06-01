package ru.iehtu.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.iehtu.sfgdi.services.ConstructorGreetingService;
import ru.iehtu.sfgdi.services.PropertyGreetingService;
import ru.iehtu.sfgdi.services.SetterGreetingService;

@Configuration
public class GreetingServiceConfig {
    
    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }  

    @Bean
    PropertyGreetingService propertyGreetingService(){
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService(){
        return new SetterGreetingService();
    }
}
