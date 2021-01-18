package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.VilleDepart;
import com.SmartCity.covoiturage.repository.villeDepartRepository;
import com.SmartCity.covoiturage.repository.villeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleDepartService {

    @Autowired
    private villeDepartRepository villeDepartR;

    @Autowired
    private VilleService villeService;

    public VilleDepart saveVilleDepart(VilleDepart villeDepart){
       return villeDepartR.save(villeDepart);
    }
    public VilleDepart saveVilleDepartByVille(Long idVille){
        VilleDepart vd=new VilleDepart();
        vd.setVille_vd(villeService.getVilleById(idVille));
        vd.setNomVilleD(villeService.getNomVille(idVille));
        return villeDepartR.save(vd);
    }

   public List<VilleDepart> saveVilleDeparts(List<VilleDepart> villeDeparts){
        return villeDepartR.saveAll(villeDeparts);  }

        public List<VilleDepart> getVilleDeparts(){
        return villeDepartR.findAll();
        }

        public VilleDepart getVilleDepartById(Long id){
        return villeDepartR.findById(id).orElse(null);
        }

    public VilleDepart updateVilleDepart(VilleDepart villeDepart) {
          VilleDepart existingVilleDepart=villeDepartR.findById(villeDepart.getIdVilleD()).orElse(null);
          return villeDepartR.save(existingVilleDepart);
    }
    public String deleteVilleDepart(Long id){
        villeDepartR.deleteById(id);
        return "ville depart supprimé";
    }
}
