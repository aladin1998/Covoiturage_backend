package com.SmartCity.covoiturage.service;

import com.SmartCity.covoiturage.model.*;
import com.SmartCity.covoiturage.repository.passagerRepository;
import com.SmartCity.covoiturage.repository.passagerTrajetRepository;
import com.SmartCity.covoiturage.repository.trajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PassagerTrajetService {

    @Autowired
    private passagerTrajetRepository passagerTrajetR;

    @Autowired
    private PassagerService passagerService;

    @Autowired
    private TrajetService trajetService;

    @Autowired

    private passagerRepository pRepository;


    @Autowired
    private UtilisateurService utilisateurService;

    public PassagerTrajet savePassagerTrajet(PassagerTrajet passagerTrajet){
        passagerTrajet.setActivated(false);


       return passagerTrajetR.save(passagerTrajet);
    }
    public int countByTrajet(Long idTrajet){
        return passagerTrajetR.countByTrajet(idTrajet);
    }
   public List<PassagerTrajet> savePassagers(List<PassagerTrajet> passagerTrajets){
        return passagerTrajetR.saveAll(passagerTrajets);  }

        public List<PassagerTrajet> gertPassagers(){
        return passagerTrajetR.findAll();
        }

        public PassagerTrajet gertPassagerById(Long idPassager,Long idTrajet){
            PassagerTrajetId ID=new PassagerTrajetId();
            ID.setPassager(passagerService.gertPassagerById(idPassager));
            ID.setTrajet(trajetService.getTrajetById(idTrajet));
        return passagerTrajetR.findById(ID).orElse(null);
        }

    public List<Passager> gertPassagerByIdTrajet(Long idTrajet){
        List<Passager> passagers=new ArrayList<>();
        List<PassagerTrajet> passaerTrajers=passagerTrajetR.findPassagersByIdTrajet(idTrajet);
        for(int i=0;i<passaerTrajers.size();i++){
            passagers.add(passaerTrajers.get(i).getPassager());
        }
       return passagers;
    }

    public List<PassagerTrajet> gertPassagerTrajetByIdTrajet(Long idTrajet){

        return passagerTrajetR.findPassagersByIdTrajet(idTrajet);
    }

    public PassagerTrajet updatePassagerTrajet(PassagerTrajet passagerTrajet) {
          PassagerTrajet existingPassager=passagerTrajetR.findById(passagerTrajet.getId()).orElse(null);
          return passagerTrajetR.save(existingPassager);
    }

    public PassagerTrajet reserver(Long idPassager,Long idTrajet){
        PassagerTrajet pt=new PassagerTrajet();
       Passager p=new Passager() ;
        Trajet t=new Trajet();
      Utilisateur u=new Utilisateur();
      u=utilisateurService.getUtilisateurById(idPassager);
         p=passagerService.getPassagerByUtilisateur(u);
         t=trajetService.getTrajetById(idTrajet);
         pt.setActivated(false);
         pt.setTrajet(t);
         pt.setRegisteredDate(new Date());
         pt.setPassager(p);



         return passagerTrajetR.save(pt);
       //  return passagerTrajetR.reserver(idPassager,idTrajet,false,"2021-01-07");

     // return passagerTrajetR.reserver(1L,1L,false,"2020-12-16");

    }

    public PassagerTrajet accepterReservation(Long idPassager,Long idTrajet) {
        PassagerTrajet pt=passagerTrajetR.findPTByTP(idTrajet,idPassager);
        pt.setActivated(true);

        return passagerTrajetR.save(pt);
    }

    public String supprimerPT(Long idTrajet,Long idPassger){
           PassagerTrajet pt=passagerTrajetR.findPTByTP(idTrajet,idPassger);
           passagerTrajetR.deleteById(pt.getId());
        return "demande de reservation est supprimé";
    }

}
