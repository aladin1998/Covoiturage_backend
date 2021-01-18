package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.*;
import com.SmartCity.covoiturage.repository.conducteurRepository;
import com.SmartCity.covoiturage.repository.trajetRepository;
import com.SmartCity.covoiturage.repository.villeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrajetService {

    @Autowired
    private trajetRepository trajetR;

    @Autowired
    private villeRepository  villeR;

    @Autowired
    private conducteurRepository conducteurR;

    @Autowired
    private com.SmartCity.covoiturage.repository.villeArriveeRepository villeArriveeRepository;

    @Autowired
    private com.SmartCity.covoiturage.repository.villeDepartRepository villeDepartRepository;

    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private VilleDepartService villeDepartService;

    @Autowired
    private VilleAriveeService villeAriveeService;

    @Autowired
    private VoitureService voitureService;

    public Trajet saveTrajet(Trajet trajet){
      //  trajet.setEstValide(false);
        return trajetR.save(trajet);
    }
   public List<Trajet> saveTrajets(List<Trajet> trajets){
        return trajetR.saveAll(trajets);  }

        public List<Trajet> getTrajets(){

        return trajetR.findAll();
        }

    public List<Trajet> getInvalidTrajets(){
     List<Trajet> trajets=new ArrayList<>();
        List<Trajet> invalidTrajets=new ArrayList<>();
     trajets=trajetR.findAll();
     for(int i=0;i<trajets.size();i++){
          if(trajets.get(i).getEstValide()==false) invalidTrajets.add(trajets.get(i));

     }
        return invalidTrajets;
    }

        public Trajet getTrajetById(Long id){
        return trajetR.findById(id).orElse(null);
        }

    public Trajet updateTrajet(Trajet trajet) {
          Trajet existingTrajet=trajetR.findById(trajet.getIdTrajet()).orElse(null);
          return trajetR.save(existingTrajet);
    }

    public List<Trajet> chercherTrajet(String villeDepart,String villeArrivee,String date){

        return trajetR.getSearchResult(villeDepart,villeArrivee,date);

    }

    public List<Conducteur> chercherTrajetConducteur(String villeDepart, String villeArrivee, String date){
        ArrayList<Long> arrId=new ArrayList<>();
        arrId= (ArrayList<Long>) trajetR.getSearchResultIdConducteur(villeDepart,villeArrivee,date);

        ArrayList<Conducteur> arrConducteur=new ArrayList<>();
        for(int i=0;i<arrId.size();i++){
            arrConducteur.add(conducteurService.getConducteurById(arrId.get(i)));
        }

        return arrConducteur;

    }

    public Trajet proposerTrajet(Trajet trajet,Long idConducteur,Long idVilleA,Long idVilleD,String marque,String modele,int nbPMax) throws ParseException {
        trajet.setEstValide(false);
       // DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
       // Date date = format.parse(dateDepart);
        trajet.setConducteur(conducteurService.getConducteurById(idConducteur));
       VilleDepart vd=villeDepartService.saveVilleDepartByVille(idVilleD);
        trajet.setVilleD(vd);

        VilleArrivee va=villeAriveeService.saveVilleArriveeByVille(idVilleA);
        trajet.setVilleA(va);

        Voiture v=new Voiture();
        v.setMarque(marque);
        v.setModele(modele);
        v.setNbPLaces(nbPMax);
        v.setConducteur(conducteurService.getConducteurById(idConducteur));
        voitureService.saveVoiture(v);

        return trajetR.save(trajet);

    }

    public Trajet activerTrajet(Long idTrajet){
        Trajet trajet=trajetR.findById(idTrajet).orElse(null);
        trajet.setEstValide(true);
        return trajetR.save(trajet);

    }

    public String deleteUtilisateur(Long id){
        trajetR.deleteById(id);
        return "Trajet supprimé";
    }



}
