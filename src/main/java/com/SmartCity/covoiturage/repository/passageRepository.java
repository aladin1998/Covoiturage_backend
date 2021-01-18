package com.SmartCity.covoiturage.repository;


import com.SmartCity.covoiturage.model.Passage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface passageRepository extends JpaRepository<Passage,Long> {
}
