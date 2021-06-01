package ru.iehtu.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    
    @Autowired
    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }
    public String petName(){
        return petService.getPet().getName();
    }
}
