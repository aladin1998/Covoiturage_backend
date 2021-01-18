package com.SmartCity.covoiturage.controller;


import com.SmartCity.covoiturage.model.Passage;
import com.SmartCity.covoiturage.service.PassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassageController {

    @Autowired
    PassageService passageService;

    @CrossOrigin
    @PostMapping("/addPassage")
    public Passage addPassage(@RequestBody Passage passage){
        return  passageService.savePassage(passage);
    }

    @CrossOrigin
    @GetMapping("/Passages")
    public List<Passage> getPassages(){
        return passageService.getPassages();
    }
}
