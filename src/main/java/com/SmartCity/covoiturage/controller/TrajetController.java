package com.SmartCity.covoiturage.controller;


import com.SmartCity.covoiturage.model.*;
import com.SmartCity.covoiturage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TrajetController {

    @Autowired
    TrajetService trajetService;

    @Autowired
    AdminService adminService;

    @Autowired
    ConducteurService conducteurService;

    @Autowired
    VilleDepartService villeDService;

    @Autowired
    VilleAriveeService villeAriveeService;

    @CrossOrigin
    @PostMapping("/addTrajet/{idVilleA}_{idVilleD}_{idConducteur}_{marque}_{modele}_{nbPMax}")
    public Trajet proposerTrajet( @RequestBody Trajet trajet,
                               //   @PathVariable String dateDepart,
                                  @PathVariable Long idVilleA,
                                  @PathVariable Long idVilleD,
                                  @PathVariable Long idConducteur,
                                  @PathVariable String marque,
                                  @PathVariable String modele,
                                  @PathVariable int nbPMax

    ) throws ParseException {

        return  trajetService.proposerTrajet(trajet,idConducteur,idVilleA,idVilleD,marque,modele,nbPMax);
    }

    @CrossOrigin
    @GetMapping("api/public/Trajets")
    public List<Trajet> getTrajets(){
        return trajetService.getTrajets();
    }

    @CrossOrigin
    @GetMapping("api/public/invalidTrajets")
    public List<Trajet> getInvalidTrajets(){
        return trajetService.getInvalidTrajets();
    }


    @CrossOrigin
    @GetMapping("/api/public/Trajets/{id}")
    public Trajet getTrajets(@PathVariable Long id){
        return trajetService.getTrajetById(id);
    }

    @CrossOrigin
    @GetMapping("/api/public/chercherTrajet/{villeD}_{villeA}_{date}")
    public List<Trajet> getTrajets(@PathVariable String villeD, @PathVariable String villeA, @PathVariable String date){
          return trajetService.chercherTrajet(villeD,villeA,date);
    }

    @CrossOrigin
    @GetMapping("/api/public/chercherTrajetConducteur/{villeD}_{villeA}_{date}")
    public List<Conducteur> getTrajetsConducteur(@PathVariable String villeD, @PathVariable String villeA, @PathVariable String date){
        return trajetService.chercherTrajetConducteur(villeD,villeA,date);
    }

    @CrossOrigin
    @PutMapping("/api/public/activetTrajet/{idTrajet}")
    public Trajet activetTrajet(@PathVariable Long idTrajet){
        return trajetService.activerTrajet(idTrajet);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/api/public/deleteTrajet/{idTrajet}")
    public String deleteTrajet(@PathVariable Long idTrajet){
        return trajetService.deleteUtilisateur(idTrajet);
    }



}
