package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface voitureRepository extends JpaRepository<Voiture,Long> {
    @Query(value="Select v.* FROM voiture v,trajet t,conducteur c WHERE t.conducteur_id=c.id_conducteur AND t.id_trajet=?1 AND c.id_conducteur=v.conducteur_id;",nativeQuery = true)
    public List<Voiture> getVoituresByTrajet(Long idTrajet);
}
