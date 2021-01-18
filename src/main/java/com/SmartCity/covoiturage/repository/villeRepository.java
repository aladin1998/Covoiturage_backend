package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface villeRepository extends JpaRepository<Ville,Long> {

    @Query(value = "SELECT * FROM Ville v WHERE v.nom_ville=?1",nativeQuery = true)
    public Ville getVilleByName(String nomVille);
    @Query(value = "SELECT nom_ville FROM Ville v WHERE v.id_ville=?1",nativeQuery = true)
      public String getnomVilleById(Long id);
}
