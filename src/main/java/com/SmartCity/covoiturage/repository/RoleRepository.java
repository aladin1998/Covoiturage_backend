package com.SmartCity.covoiturage.repository;



import com.SmartCity.covoiturage.model.ERole;
import com.SmartCity.covoiturage.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}