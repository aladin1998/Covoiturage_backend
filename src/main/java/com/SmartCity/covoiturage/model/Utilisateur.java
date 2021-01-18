package com.SmartCity.covoiturage.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public  class Utilisateur {


    public Utilisateur(String username,String email,String password){
      this.username=username;
      this.email=email;
      this.password=password;
    }

    /*email,username,nom,prenom,cni,deplomes,datNais,gsm, password */

    public Utilisateur(
            String email,
            String username,
            String nom,
            String prenom,
            String cni,
            String deplomes,
            Date dateNais,
            String gsm,
            String password
    ) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gsm = gsm;
        this.deplomes = deplomes;
        this.dteNais = dteNais;
        this.cni = cni;
    }

    public Utilisateur(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_utilisateur")
    private   Long id;

    @Column
    private  String nom;

    @Column
    private String prenom;

    @Column
    @Email
    @NotBlank
    private String email;


    @Column
    private String username;



    private String password;

    @JsonIgnoreProperties("roles")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Column
    private String gsm;
    @Column
    private String deplomes;

    @Column
    private String centresInteret;

    @Column
    @Temporal(TemporalType.DATE)
    public Date dteNais;

  //  @JsonBackReference(value="conducteurM")
    @OneToOne(mappedBy = "utilisateurC")
    private Conducteur conducteurM;

    @JsonBackReference(value="utilisateur")
    @OneToOne(mappedBy = "utilisateur")
    private Passager passager;

    protected String cni;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Conducteur getConducteurM() {

        return conducteurM;
    }

    public void setConducteurM(Conducteur conducteurM) {
        this.conducteurM = conducteurM;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getDeplomes() {
        return deplomes;
    }

    public void setDeplomes(String deplomes) {
        this.deplomes = deplomes;
    }

    public String getCentresInteret() {
        return centresInteret;
    }

    public void setCentresInteret(String centresInteret) {
        this.centresInteret = centresInteret;
    }

    public Date getDteNais() {
        return dteNais;
    }

    public void setDteNais(Date dteNais) {
        this.dteNais = dteNais;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }
}
