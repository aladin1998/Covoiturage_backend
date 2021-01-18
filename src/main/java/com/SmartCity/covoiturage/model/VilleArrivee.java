package com.SmartCity.covoiturage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="ville_arrivee")
@Data
public class VilleArrivee  {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_va")
    private Long idVilleA;

    @Column(name="nom_va")
    private String nomVilleA;

    @JsonIgnore
    @OneToOne(mappedBy="villeA",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Trajet trajet;


    @JsonIgnoreProperties("villeArrivee")
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private Ville ville_va;


    public Long getIdVilleA() {
        return idVilleA;
    }

    public void setIdVilleA(Long idVilleA) {
        this.idVilleA = idVilleA;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public Ville getVille_va() {
        return ville_va;
    }

    public void setVille_va(Ville ville_va) {
        this.ville_va = ville_va;
    }

    public String getNomVilleA() {
        return nomVilleA;
    }

    public void setNomVilleA(String nomVilleA) {
        this.nomVilleA = nomVilleA;
    }
}
