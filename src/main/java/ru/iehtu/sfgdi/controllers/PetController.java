package ru.iehtu.sfgdi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import ru.iehtu.pets.PetService;

@Controller
public class PetController {
    private final PetService petService;
    public PetController(PetService petService){
        this.petService = petService;
    }
    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
    
}
