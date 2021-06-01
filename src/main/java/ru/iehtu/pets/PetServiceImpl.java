package ru.iehtu.pets;

import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService{

    private final Pet pet;
    public PetServiceImpl(Pet pet) {
        this.pet = pet;
    }

    public PetServiceImpl() {
        this.pet = new Pet("Милка", null);
    }

    @Override
    public Pet getPet() {
        return pet;
    }
    
}
