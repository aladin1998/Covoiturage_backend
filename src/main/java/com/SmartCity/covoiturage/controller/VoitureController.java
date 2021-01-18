package com.SmartCity.covoiturage.controller;

import com.SmartCity.covoiturage.model.Voiture;
import com.SmartCity.covoiturage.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @CrossOrigin
    @GetMapping("/api/public/getVoiture/{idTrajet}")
    public Voiture getVoiture(@PathVariable Long idTrajet){
        return voitureService.getVoiture(idTrajet);
    }
}
