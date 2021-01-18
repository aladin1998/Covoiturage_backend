package com.SmartCity.covoiturage.controller;



import com.SmartCity.covoiturage.model.VilleDepart;
import com.SmartCity.covoiturage.service.VilleDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VilleDController {

    @Autowired
    VilleDepartService villeDepartService;

    @CrossOrigin
    @GetMapping("/villeDeparts")
    public List<VilleDepart> getVilleDeparts(){
        return  villeDepartService.getVilleDeparts();
    }

    @CrossOrigin
    @GetMapping("/villeDeparts/{id}")
    public VilleDepart getVilleDeparts(@PathVariable Long id){
        return  villeDepartService.getVilleDepartById(id);
    }

    @CrossOrigin
    @PostMapping("/addVilleDepart")
    public VilleDepart addVilleDepart(@RequestBody VilleDepart villeDepart){
        return  villeDepartService.saveVilleDepart(villeDepart);
    }

    @CrossOrigin
    @PutMapping("/updateVilleDepart")
    public VilleDepart updateVilleDepart(@RequestBody VilleDepart villeDepart){
        return villeDepartService.updateVilleDepart(villeDepart);
    }

    @CrossOrigin
    @DeleteMapping("/deleteVilleDepart/{id}")
    public String deleteVilleDepart(Long id){
        return villeDepartService.deleteVilleDepart(id);
    }


}
