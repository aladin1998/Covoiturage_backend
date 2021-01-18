package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.Conducteur;
import com.SmartCity.covoiturage.model.Utilisateur;
import com.SmartCity.covoiturage.repository.conducteurRepository;
import com.SmartCity.covoiturage.repository.utilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private utilisateurRepository utilisateurR;

    @Autowired
    private conducteurRepository conducteurR;

    public Utilisateur saveUtilisateur(Utilisateur Utilisateur){
       return utilisateurR.save(Utilisateur);
    }

   public List<Utilisateur> saveUtilisateur(List<Utilisateur> utilisateurs){
        return utilisateurR.saveAll(utilisateurs);  }

        public List<Utilisateur> getUtilisateurs(){
        return utilisateurR.findAll();
        }

        public Utilisateur getUtilisateurById(Long id){
        return utilisateurR.findById(id).orElse(null);
        }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur,Long idUser) {
              utilisateur.setId(idUser);
          Utilisateur user=utilisateurR.findById(utilisateur.getId()).orElse(null);
         user.setId(idUser);
        if(utilisateur.getUsername()!=null)  user.setUsername(utilisateur.getUsername());
        if(utilisateur.getNom()!=null)  user.setNom(utilisateur.getNom());
        if(utilisateur.getPrenom()!=null)  user.setPrenom(utilisateur.getPrenom());
        if(utilisateur.getEmail()!=null)    user.setEmail(utilisateur.getEmail());
        if(utilisateur.getCni()!=null)   user.setCni(utilisateur.getCni());
        if(utilisateur.getGsm()!=null)  user.setGsm(utilisateur.getGsm());
          return utilisateurR.save(user);
    }

    public Utilisateur getUtilisateurByConducteur(Long idConducteur){

        return utilisateurR.findByConducteurM(idConducteur);

    }
    public String deleteUtilisateur(Long id){
        utilisateurR.deleteById(id);
        return "Utilisateur supprimé";
    }




}
