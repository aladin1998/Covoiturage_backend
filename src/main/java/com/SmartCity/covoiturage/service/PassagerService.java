package com.SmartCity.covoiturage.service;

import com.SmartCity.covoiturage.model.Passager;
import com.SmartCity.covoiturage.model.Utilisateur;
import com.SmartCity.covoiturage.repository.passagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagerService {

    @Autowired
    private passagerRepository passagerR;

    public Passager savePassager(Passager passager){
       return passagerR.save(passager);
    }
   public List<Passager> savePassagers(List<Passager> passagers){
        return passagerR.saveAll(passagers);  }

        public Passager getPassagerByUtilisateur(Utilisateur utilisateur){
            return passagerR.findByUtilisateur(utilisateur);
        }

        public List<Passager> gertPassagers(){
        return passagerR.findAll();
        }

        public Passager gertPassagerById(Long id){
        return passagerR.findById(id).orElse(null);
        }

    public Passager updatePassager(Passager passager) {
          Passager existingPassager=passagerR.findById(passager.getIdPassager()).orElse(null);
          return passagerR.save(existingPassager);
    }
}
