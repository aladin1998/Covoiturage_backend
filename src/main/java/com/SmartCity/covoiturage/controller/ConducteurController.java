
package com.SmartCity.covoiturage.controller;

import com.SmartCity.covoiturage.model.Conducteur;
import com.SmartCity.covoiturage.model.Voiture;
import com.SmartCity.covoiturage.service.ConducteurService;
import com.SmartCity.covoiturage.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ConducteurController {

    @Autowired
    ConducteurService conducteurService;

    @Autowired
    UtilisateurService utilisateurService;

    @CrossOrigin
    @GetMapping("/api/public/Tconducteurs")
    public List<Conducteur> getConducteurs(){
        return  conducteurService.getConducteurs();
    }

    @CrossOrigin
    @GetMapping("/api/public/Tconducteurs/{id}")
    public Conducteur getConducteurs(@PathVariable Long id){
        return  conducteurService.getConducteurById(id);
    }

    @CrossOrigin
    @GetMapping("/api/public/conducteurByUserId/{idUser}")
    public Conducteur getConducteurByUser(@PathVariable Long idUser){
        return conducteurService.getConducteurByUser(idUser);
    }

    @CrossOrigin
    @PostMapping("/addConducteur")
    public Conducteur addConducteur(@RequestBody Conducteur conducteur){

        conducteur.setUtilisateurC(utilisateurService.getUtilisateurById(1L));
        return  conducteurService.saveConducteur(conducteur);
    }

    @CrossOrigin
    @PutMapping("/updateConducteur")
    public Conducteur updateConduceteur(@RequestBody Conducteur conducteur){
        return conducteurService.updateConducteur(conducteur);
    }

    @CrossOrigin
    @DeleteMapping("/deleteConducteur/{id}")
    public String deleteConducteur(Long id){
        return conducteurService.deleteConducteur(id);
    }

    @CrossOrigin
    @GetMapping("/api/public/getConducteur/{idTrajet}")
    public Conducteur getVoiture(@PathVariable Long idTrajet){
        return conducteurService.getConducteurByTrajet(idTrajet);
    }

}
