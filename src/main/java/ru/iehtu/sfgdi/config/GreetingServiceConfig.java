package ru.iehtu.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import ru.iehtu.pets.PetService;
import ru.iehtu.pets.PetServiceFactory;
import ru.iehtu.sfgdi.datasource.FakeDataSource;
import ru.iehtu.sfgdi.repositories.EnglishGreetingRepository;
import ru.iehtu.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import ru.iehtu.sfgdi.services.ConstructorGreetingService;
import ru.iehtu.sfgdi.services.I18nEnglishGreetingService;
import ru.iehtu.sfgdi.services.I18nSpanishGreetingService;
import ru.iehtu.sfgdi.services.PrimaryGreetingService;
import ru.iehtu.sfgdi.services.PropertyGreetingService;
import ru.iehtu.sfgdi.services.SetterGreetingService;


// @PropertySource("classpath:datasource.properties")
@EnableConfigurationProperties(SfgConstructorConfig.class)
@ImportResource("classpath:sfgdi-config.xml")

@Configuration

public class GreetingServiceConfig {
    
    @Bean
    FakeDataSource fakeDataSource(SfgConfiguration sfgConfiguration){
        FakeDataSource fakeDataSource = new FakeDataSource();
        
        fakeDataSource.setUsername(sfgConfiguration.getUsername());
        fakeDataSource.setPassword(sfgConfiguration.getPassword());
        fakeDataSource.setJdbcurl(sfgConfiguration.getJdbcurl());

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

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

    // @Bean
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
