package com.SmartCity.covoiturage.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Voiture {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;
    private String marque;
    private String modele;
    private int nbPLaces;
    private String coleur;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "conducteur_id",nullable = false)
    private Conducteur conducteur;

    public Long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getNbPLaces() {
        return nbPLaces;
    }

    public void setNbPLaces(int nbPLaces) {
        this.nbPLaces = nbPLaces;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }
}
