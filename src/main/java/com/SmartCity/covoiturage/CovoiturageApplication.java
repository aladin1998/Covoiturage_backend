package com.SmartCity.covoiturage;

import com.SmartCity.covoiturage.model.Ville;
import com.SmartCity.covoiturage.model.VilleDepart;
import com.SmartCity.covoiturage.service.VilleDepartService;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class CovoiturageApplication {


	public static void main(String[] args) {
		SpringApplication.run(CovoiturageApplication.class, args);




	}

}
