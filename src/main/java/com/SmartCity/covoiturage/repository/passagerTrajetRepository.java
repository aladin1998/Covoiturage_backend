package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.Passager;
import com.SmartCity.covoiturage.model.PassagerTrajet;
import com.SmartCity.covoiturage.model.PassagerTrajetId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface passagerTrajetRepository extends JpaRepository<PassagerTrajet, PassagerTrajetId> {


    @Query(value = "INSERT INTO passager_trajet (passager_id,trajet_id,activated,registered_date) VALUES (?1,?2,?3,?4);",nativeQuery = true)
    public PassagerTrajet reserver(Long idPassager,Long idTrajet,boolean isActivated,String date);

    @Query(value = "SELECT COUNT(*) FROM passager_trajet WHERE trajet_id_trajet=?1 ",nativeQuery = true)
    public int countByTrajet(Long idTrajet);

    @Query(value = "SELECT * FROM passager_trajet  WHERE trajet_id_trajet=?1",nativeQuery = true)
    public List<PassagerTrajet> findPassagersByIdTrajet(Long idTrajet);

    @Query(value = "SELECT * FROM passager_trajet  WHERE trajet_id_trajet=?1 AND passager_id_passger=?2",nativeQuery = true)
    public PassagerTrajet findPTByTP(Long idTrajet,Long idPassager);
}
