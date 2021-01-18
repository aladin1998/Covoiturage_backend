

package com.SmartCity.covoiturage.controller;


import com.SmartCity.covoiturage.model.Utilisateur;
import com.SmartCity.covoiturage.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/public")
@RestController
public class UtilisateurController {


    @Autowired
    UtilisateurService utilisateurService;

      @CrossOrigin
    @PostMapping("/createAccount")
    public Utilisateur createAccount(@RequestBody Utilisateur utilisateur){
          return utilisateurService.saveUtilisateur(utilisateur);
      }

    @CrossOrigin
    @PutMapping("/updateAccount/{idUser}")
    public Utilisateur updateAccount(@RequestBody Utilisateur utilisateur,@PathVariable Long idUser){
        return utilisateurService.updateUtilisateur(utilisateur,idUser);
    }

    @CrossOrigin
    @GetMapping("/getUser/{id}")
    public Utilisateur getUserById(@PathVariable Long id){
         return utilisateurService.getUtilisateurById(id);
    }

    @CrossOrigin
    @GetMapping("/getUsers")
    public List<Utilisateur> getUserById(){
        return utilisateurService.getUtilisateurs();
    }

    @CrossOrigin
    @GetMapping("/getUsersByConducteur/{idConducteur}")
    public Utilisateur getUserByConducteur(@PathVariable Long idConducteur){
        return utilisateurService.getUtilisateurByConducteur(idConducteur);
    }


/*
      @CrossOrigin
      @PostMapping("/estExist")
          public Boolean estExist(@RequestBody Utilisateur utilisateur){
          return  utilisateurService.estExist(utilisateur);
          }*/

}
