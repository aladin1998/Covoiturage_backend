package com.SmartCity.covoiturage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.SmartCity.covoiturage.model.*;
import com.SmartCity.covoiturage.payload.request.LoginRequest;
import com.SmartCity.covoiturage.payload.request.SignupRequest;
import com.SmartCity.covoiturage.payload.response.JwtResponse;
import com.SmartCity.covoiturage.payload.response.MessageResponse;
import com.SmartCity.covoiturage.repository.RoleRepository;
import com.SmartCity.covoiturage.repository.passagerRepository;
import com.SmartCity.covoiturage.repository.utilisateurRepository;
import com.SmartCity.covoiturage.security.jwt.JwtUtils;
import com.SmartCity.covoiturage.security.services.UserDetailsImpl;
import com.SmartCity.covoiturage.service.ConducteurService;
import com.SmartCity.covoiturage.service.PassagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;


	@Autowired
	utilisateurRepository userRepository;

	@Autowired
	passagerRepository passagerRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
    PassagerService passagerService;

	@Autowired
	ConducteurService conducteurService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 
												 roles));
	}

	public Date convertStringToDate(String date) throws ParseException {

		Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(date);
		return date1;

	}

	@PostMapping("/signup/{date}_{myRole}")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, @PathVariable String date,@PathVariable String myRole) throws ParseException {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		/*email,username,nom,prenom,cni,deplomes,datNais,gsm, password */
		Utilisateur user = new Utilisateur(signUpRequest.getEmail(),signUpRequest.getUsername(),
							signUpRequest.getNom(),
							 signUpRequest.getPrenom(),
							 signUpRequest.getCni(),
							 signUpRequest.getDeplomes(),
							 signUpRequest.getDteNais(),
							 signUpRequest.getGsm(),
							 encoder.encode(signUpRequest.getPassword()));


		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
/*
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_PASSAGER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_CONDUCTEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_PASSAGER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}*/
		Set<Role> myRoles = new HashSet<>();
		//user.setRoles(roles);
		Role r=roleRepository.findByName(this.getRole(myRole)).get();
		myRoles.add(r);
		user.setRoles(myRoles);

		user.setDteNais(convertStringToDate(date));
        user.setNom(myRole);
		userRepository.save(user);
		if(r.getName()==ERole.ROLE_CONDUCTEUR){
			Conducteur c=new Conducteur();
			c.setUtilisateurC(user);
			c.setNom(user.getNom()+" "+user.getPrenom());
			conducteurService.saveConducteur(c);
		}
		else if(r.getName()==ERole.ROLE_PASSAGER){
			  Passager p=new Passager();
             p.setUtilisateurP(user);
			passagerService.savePassager(p);
		}


	/*	Passager passager=new Passager();
		passager.setUtilisateurP(user);
		passagerService.savePassager(passager);*/
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	public ERole getRole(String role){
		ERole erole=null;
		if(role.equals("PASSAGER")) erole=ERole.ROLE_PASSAGER;
		else if(role.equals("CONDUCTEUR")) erole=ERole.ROLE_CONDUCTEUR;
		else erole=ERole.ROLE_ADMIN;

		return erole;

	}
}
