package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.Ville;
import com.SmartCity.covoiturage.repository.villeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {

    @Autowired
    private villeRepository villeR;

    public Ville saveVille(Ville ville){
        return villeR.save(ville);
    }
    public List<Ville> saveVilles(List<Ville> villes){
        return villeR.saveAll(villes);  }

    public List<Ville> getVilles(){
        return villeR.findAll();
    }

    public Ville getVilleById(Long id){
        return villeR.findById(id).orElse(null);
    }

    public Ville updateVille(Ville ville) {
        Ville existingVille= villeR.findById(ville.getIdVille()).orElse(null);
        return villeR.save(ville);
    }
    public String deleteVille(Long id){
        villeR.deleteById(id);
        return "ville  supprimé";
    }
        public String getNomVille(Long id){
        return villeR.getnomVilleById(id);
        }
}
