package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.Ville;
import com.SmartCity.covoiturage.model.VilleArrivee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface villeArriveeRepository extends JpaRepository<VilleArrivee,Long> {

    @Query(value = "SELECT v.id_va FROM ville_arrivee v WHERE ville_va_id_ville=?1",nativeQuery = true)
    public Long getVilleAByVille(Long ville);
}
