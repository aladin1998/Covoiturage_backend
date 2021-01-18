package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.VilleArrivee;
import com.SmartCity.covoiturage.model.VilleDepart;
import com.SmartCity.covoiturage.repository.villeArriveeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleAriveeService {

    @Autowired
    private villeArriveeRepository villeArriveeR;

    @Autowired
    private VilleService villeService;

    public VilleArrivee saveVilleArrivee(VilleArrivee villeArrivee){
       return villeArriveeR.save(villeArrivee);
    }

   public VilleArrivee saveVilleArriveeByVille(Long idVille){
       VilleArrivee va=new VilleArrivee();
       va.setVille_va(villeService.getVilleById(idVille));
       va.setNomVilleA(villeService.getNomVille(idVille));
       return villeArriveeR.save(va);
   }
   public List<VilleArrivee> saveVilleArrivees(List<VilleArrivee> villeArrivees){
        return villeArriveeR.saveAll(villeArrivees);  }

        public List<VilleArrivee> getVilleArrivees(){
        return villeArriveeR.findAll();
        }

        public VilleArrivee getVilleArriveeById(Long id){
        return villeArriveeR.findById(id).orElse(null);
        }

    public VilleArrivee updateVilleArrivee(VilleArrivee villeArrivee) {
          VilleArrivee existingVilleArrivee=villeArriveeR.findById(villeArrivee.getIdVilleA()).orElse(null);
          return villeArriveeR.save(existingVilleArrivee);
    }

    public String deleteVilleArivee(Long id){
        villeArriveeR.deleteById(id);
        return "ville arrivée supprimé";
    }
}
