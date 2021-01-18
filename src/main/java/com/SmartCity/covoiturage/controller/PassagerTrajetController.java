package com.SmartCity.covoiturage.controller;


import com.SmartCity.covoiturage.model.Passage;
import com.SmartCity.covoiturage.model.Passager;
import com.SmartCity.covoiturage.model.PassagerTrajet;
import com.SmartCity.covoiturage.service.PassageService;
import com.SmartCity.covoiturage.service.PassagerService;
import com.SmartCity.covoiturage.service.PassagerTrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/api/public")
@RestController
public class PassagerTrajetController {



    @Autowired
    PassagerTrajetService passagerTrajetService;

    @CrossOrigin
    @PostMapping("/reserver/{idPassager}_{idTrajet}")
    public PassagerTrajet addPassage(@PathVariable Long idPassager,@PathVariable Long idTrajet){
        return passagerTrajetService.reserver(idPassager,idTrajet);
    }

    @CrossOrigin
    @PutMapping("/accepterReservation/{idPassager}_{idTrajet}")
    public PassagerTrajet accepterReservation(@PathVariable Long idPassager,@PathVariable Long idTrajet){
        return passagerTrajetService.accepterReservation(idPassager,idTrajet);
    }



    @CrossOrigin
    @GetMapping("/PTs")
    public List<PassagerTrajet> getNomVille(){
        return passagerTrajetService.gertPassagers();
    }


    @CrossOrigin
    @GetMapping("/PassaersByTrajet/{idTrajet}")
    public List<Passager> getPassagers(@PathVariable Long idTrajet){
        return passagerTrajetService.gertPassagerByIdTrajet(idTrajet);
    }

    @CrossOrigin
    @GetMapping("/PassaerTrajetsByTrajet/{idTrajet}")
    public List<PassagerTrajet> getPassagersTrajets(@PathVariable Long idTrajet){
        return passagerTrajetService.gertPassagerTrajetByIdTrajet(idTrajet);
    }


    @CrossOrigin
    @GetMapping("/PTs/{idPassager}_{idTrajet}")
    public PassagerTrajet getNomVille(@PathVariable Long idPassager,@PathVariable Long idTrajet){
        return passagerTrajetService.gertPassagerById(idPassager,idTrajet);
    }



    @CrossOrigin
    @GetMapping("/countPassagerByTrajet/{idTrajet}")
    public int countByTrajet(@PathVariable Long idTrajet){
        return passagerTrajetService.countByTrajet(idTrajet);
    }


    @CrossOrigin
    @DeleteMapping("/deleteRes/{idTrajet}_{idPassager}")
    public String deleteRes(@PathVariable Long idTrajet,@PathVariable Long idPassager){
        return passagerTrajetService.supprimerPT(idTrajet,idPassager);
    }
}
