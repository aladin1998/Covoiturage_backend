package com.SmartCity.covoiturage.controller;



import com.SmartCity.covoiturage.model.VilleArrivee;
import com.SmartCity.covoiturage.service.VilleAriveeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VilleAController {

    @Autowired
    VilleAriveeService villeArriveeService;

    @CrossOrigin
    @GetMapping("/villeArrivees")
    public List<VilleArrivee> getVilleArrivees(){
        return  villeArriveeService.getVilleArrivees();
    }

    @CrossOrigin
    @GetMapping("/villeArrivees/{id}")
    public VilleArrivee getVilleArrivees(@PathVariable Long id){
        return  villeArriveeService.getVilleArriveeById(id);
    }

    @CrossOrigin
    @PostMapping("/addVilleArrivee")
    public VilleArrivee addVilleArrivee(@RequestBody VilleArrivee villeArrivee){
        return  villeArriveeService.saveVilleArrivee(villeArrivee);
    }

    @CrossOrigin
    @PutMapping("/updateVilleArrivee")
    public VilleArrivee updateVilleArrivee(@RequestBody VilleArrivee villeArrivee){
        return villeArriveeService.updateVilleArrivee(villeArrivee);
    }

    @CrossOrigin
    @DeleteMapping("/deleteVilleArrivee/{id}")
    public String deleteVilleArrivee(Long id){
        return villeArriveeService.deleteVilleArivee(id);
    }


}
