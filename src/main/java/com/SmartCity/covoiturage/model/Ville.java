package com.SmartCity.covoiturage.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
public  class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ville")
    private Long idVille;

    @Column
    private String nomVille;

    @JsonIgnoreProperties("villes")
    @ManyToMany(mappedBy="villes")
    List<Passage> passages=new ArrayList<>();

    public Long getIdVille() {
        return idVille;
    }

    @JsonIgnoreProperties("ville_va")
    @OneToMany(mappedBy = "ville_va")
    private List<VilleArrivee> villeArrivee=new ArrayList<>();

    @JsonIgnoreProperties("ville_vd")
    @OneToMany(mappedBy = "ville_vd")
    private List<VilleDepart> villeDepart=new ArrayList<>();


    public void setIdVille(Long idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public List<Passage> getPassages() {
        return passages;
    }

    public void setPassages(List<Passage> passages) {
        this.passages = passages;
    }

    public List<VilleArrivee> getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(List<VilleArrivee> villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public List<VilleDepart> getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(List<VilleDepart> villeDepart) {
        this.villeDepart = villeDepart;
    }
}
