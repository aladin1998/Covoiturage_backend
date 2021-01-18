package com.SmartCity.covoiturage.repository;

import com.SmartCity.covoiturage.model.Passager;
import com.SmartCity.covoiturage.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface passagerRepository extends JpaRepository<Passager,Long> {

    public Passager findByUtilisateur(Utilisateur utilisateur);
}
