

package com.SmartCity.covoiturage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate ;
import  java.time.LocalDateTime;
import java.util.ArrayList;
import  java.util.Date;
import    java.sql.Time;
import   java.sql.Timestamp;
import javax.persistence.*;


import java.util.List;

@Entity
@Table(name ="conducteur")
@Data
public class Conducteur  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_conducteur")
    private Long idConducteur;


    @Column(name="avisPositif")
    private int avisPositif;

    @Column(name="avisNegatif")
    private int avisNegative;

    @JsonIgnore
    @OneToMany(mappedBy = "conducteur")
    List<Voiture> voitures=new ArrayList<>();


    @OneToMany(mappedBy = "conducteur",cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    List<Trajet> trajetC=new ArrayList<>();




    @JsonManagedReference(value = "msg")
    @OneToMany(mappedBy="conducteurM")
    private List<Messagerie> msgrs=new ArrayList<>();

    // @JsonManagedReference(value = "conducteurM")
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateurC;

    @CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void   proposerTrajet(){

    }
    public void   modifierTrajet(){

    }
    public void   supprimerTrajet(){

    }
    public void  accepterDemande(){

    }

    public Long getIdConducteur() {
        return idConducteur;
    }

    public void setIdConducteur(Long idConducteur) {
        this.idConducteur = idConducteur;
    }

    public int getAvisPositif() {
        return avisPositif;
    }

    public void setAvisPositif(int avisPositif) {
        this.avisPositif = avisPositif;
    }

    public int getAvisNegative() {
        return avisNegative;
    }

    public void setAvisNegative(int avisNegative) {
        this.avisNegative = avisNegative;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public List<Messagerie> getMsgs() {
        return msgrs;
    }

    public void setMsgs(List<Messagerie> msgs) {
        this.msgrs = msgs;
    }

    public List<Trajet> getTrajetC() {
        return trajetC;
    }

    public void setTrajetC(List<Trajet> trajetC) {
        this.trajetC = trajetC;
    }

    public List<Messagerie> getMsgrs() {
        return msgrs;
    }

    public void setMsgrs(List<Messagerie> msgrs) {
        this.msgrs = msgrs;
    }

    public Utilisateur getUtilisateurC() {
        return utilisateurC;
    }

    public void setUtilisateurC(Utilisateur utilisateurC) {
        this.utilisateurC = utilisateurC;
    }
}
