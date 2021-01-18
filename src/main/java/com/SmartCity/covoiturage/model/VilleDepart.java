package com.SmartCity.covoiturage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="ville_depart")
@Data
public class VilleDepart   {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_vd")
    private Long idVilleD;

    @Column(name="nom_vd")
    private String nomVilleD;

     @JsonIgnore
    @OneToOne(mappedBy="villeD",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Trajet trajet;

    @JsonIgnoreProperties("villeDepart")
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private Ville ville_vd;

    public Ville getVille_vd() {
        return ville_vd;
    }

    public void setVille_vd(Ville ville_vd) {
        this.ville_vd = ville_vd;
    }

    public Long getIdVilleD() {
        return idVilleD;
    }


    public void setIdVilleD(Long idVilleD) {
        this.idVilleD = idVilleD;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public String getNomVilleD() {
        return nomVilleD;
    }

    public void setNomVilleD(String nomVilleD) {
        this.nomVilleD = nomVilleD;
    }
}
