package ru.iehtu.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import ru.iehtu.sfgdi.repositories.EnglishGreetingRepository;
import ru.iehtu.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import ru.iehtu.sfgdi.services.ConstructorGreetingService;
import ru.iehtu.sfgdi.services.I18nEnglishGreetingService;
import ru.iehtu.sfgdi.services.I18nSpanishGreetingService;
import ru.iehtu.sfgdi.services.PrimaryGreetingService;
import ru.iehtu.sfgdi.services.PropertyGreetingService;
import ru.iehtu.sfgdi.services.SetterGreetingService;

@Configuration
public class GreetingServiceConfig {
    
    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }


    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Bean
    @Profile("EN")
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }


    @Bean("i18nService")
    @Profile({"ES", "default"})
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

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
