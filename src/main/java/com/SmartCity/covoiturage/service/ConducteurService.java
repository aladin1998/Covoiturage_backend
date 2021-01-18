package com.SmartCity.covoiturage.service;

import com.SmartCity.covoiturage.model.*;
import com.SmartCity.covoiturage.repository.conducteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ConducteurService {

    @Autowired
    private conducteurRepository conducteurR;

    @Autowired
    private UtilisateurService utilisateurService;

    public Conducteur saveConducteur(Conducteur conducteur){
       return conducteurR.save(conducteur);
    }
   public List<Conducteur> saveConducteur(List<Conducteur> conducteurs){
        return conducteurR.saveAll(conducteurs);  }

        public List<Conducteur> getConducteurs(){
        return conducteurR.findAll();
        }



        public Conducteur getConducteurById(Long id){
        return conducteurR.findById(id).orElse(null);
        }

    public Conducteur getConducteurByUser(Long idUser){

        Utilisateur u=new Utilisateur();
        u=utilisateurService.getUtilisateurById(idUser);

        return conducteurR.findByUtilisateurC(u);
    }

    public Conducteur updateConducteur(Conducteur conducteur) {
          Conducteur existingAdmin=conducteurR.findById(conducteur.getIdConducteur()).orElse(null);
          return conducteurR.save(existingAdmin);
    }
    public String deleteConducteur(Long id){
        conducteurR.deleteById(id);
        return "conducteur supprimé";
    }

    public Conducteur getConducteurByTrajet(Long idTrajet){
        return conducteurR.getConducteurByTrajet(idTrajet);
    }


}
