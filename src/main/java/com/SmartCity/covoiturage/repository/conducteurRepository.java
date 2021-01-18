
package com.SmartCity.covoiturage.repository;


import com.SmartCity.covoiturage.model.Conducteur;
import com.SmartCity.covoiturage.model.Utilisateur;
import com.SmartCity.covoiturage.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface conducteurRepository extends JpaRepository<Conducteur,Long> {

    @Query(value="Select c.* FROM  trajet t,conducteur c WHERE t.conducteur_id=c.id_conducteur AND t.id_trajet=?1 ;",nativeQuery = true)
    public Conducteur getConducteurByTrajet(Long idTrajet);

    public Conducteur findByUtilisateurC(Utilisateur utilisateurC);
}
