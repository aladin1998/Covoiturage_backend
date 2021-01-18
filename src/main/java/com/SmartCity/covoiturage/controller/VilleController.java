package com.SmartCity.covoiturage.controller;


import com.SmartCity.covoiturage.model.Ville;
import com.SmartCity.covoiturage.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VilleController {

    @Autowired
    VilleService villeService;

    @CrossOrigin
    @GetMapping("/Villes")
    public List<Ville> getVilles(){
       return villeService.getVilles();
    }

    @CrossOrigin
    @GetMapping("/Ville_nom/{id}")
    public String getNomVille(@PathVariable Long id){
        return villeService.getNomVille(id);
    }

}
