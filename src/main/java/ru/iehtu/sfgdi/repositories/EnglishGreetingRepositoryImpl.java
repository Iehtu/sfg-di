package ru.iehtu.sfgdi.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{

    @Override
    public String sayGreeting() {
        return "Hello, world - EN";
    }
    
}
