package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.VilleArrivee;
import com.SmartCity.covoiturage.model.VilleDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface villeDepartRepository extends JpaRepository<VilleDepart,Long> {

    @Query(value = "SELECT v.id_vd FROM ville_depart  WHERE  ville_vd_id_ville=?1",nativeQuery = true)
    public Long getVilleDByVille(Long ville);

}
