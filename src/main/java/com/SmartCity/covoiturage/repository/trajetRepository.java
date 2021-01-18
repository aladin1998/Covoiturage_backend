package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.Trajet;
import com.SmartCity.covoiturage.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface trajetRepository extends JpaRepository<Trajet,Long> {

    @Query(value = "Select * from Trajet t where t.villeD_id =?1 AND t.villeA_id=?2 AND t.date_depart=?3 ORDER BY date_depart",nativeQuery = true)
    public List<Trajet> getTrajets(Long villeDepart, Long villeArrivee, String date );

    @Query(value = "SELECT t.* FROM trajet t,ville_depart vd,ville_arrivee va WHERE t.date_depart=?3 AND (t.villea_id=va.id_va and t.villed_id=vd.id_vd) AND (vd.nom_vd=?1 and va.nom_va=?2)",nativeQuery = true)
    public List<Trajet> getSearchResult(String villeDepart, String villeArrivee, String date );

    @Query(value = "SELECT conducteur_id FROM trajet t,ville_depart vd,ville_arrivee va WHERE t.date_depart=?3 AND (t.villea_id=va.id_va and t.villed_id=vd.id_vd) AND (vd.nom_vd=?1 and va.nom_va=?2)",nativeQuery = true)
    public List<Long> getSearchResultIdConducteur(String villeDepart, String villeArrivee, String date );


}
