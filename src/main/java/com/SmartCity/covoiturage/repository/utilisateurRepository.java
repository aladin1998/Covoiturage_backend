package com.SmartCity.covoiturage.repository;


import com.SmartCity.covoiturage.model.Conducteur;
import com.SmartCity.covoiturage.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface utilisateurRepository extends JpaRepository<Utilisateur,Long> {

    @Query("Select count(*) from Utilisateur u where u.cni =?1 AND u.email =?2")
    public int isExist(String cni,String email);

    Optional<Utilisateur> findByUsername(String username);

    Boolean existsByUsername(String username);



    Boolean existsByEmail(String email);

    @Query(value = "SELECT u.* FROM utilisateur u,conducteur c WHERE c.utilisateur_id=u.id_utilisateur AND c.id_conducteur=?1",nativeQuery = true)
    Utilisateur findByConducteurM(Long idConducteur);
}
