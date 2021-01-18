package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.Voiture;
import com.SmartCity.covoiturage.repository.voitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private voitureRepository voitureR;

    public Voiture saveVoiture(Voiture voiture){
       return voitureR.save(voiture);
    }
   public List<Voiture> saveVoitures(List<Voiture> voitures){
        return voitureR.saveAll(voitures);  }

        public List<Voiture> getVoitures(){
        return voitureR.findAll();
        }

        public Voiture getVoitureById(Long id){
        return voitureR.findById(id).orElse(null);
        }

    public Voiture updateVoiture(Voiture voiture) {
          Voiture existingVoiture=voitureR.findById(voiture.getIdVoiture()).orElse(null);
          return voitureR.save(existingVoiture);
    }
    public Voiture getVoiture(Long idTrajet){
        return voitureR.getVoituresByTrajet(idTrajet).get(0);
    }

}
