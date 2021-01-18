package com.SmartCity.covoiturage.repository;


import com.SmartCity.covoiturage.model.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface feedBackRepository extends JpaRepository<FeedBack,Long> {
}
