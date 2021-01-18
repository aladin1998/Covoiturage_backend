package com.SmartCity.covoiturage.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;

@Table
@Entity
@Data
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrajet;

    @Temporal(TemporalType.DATE)
    Date dateDepart;


    @JsonFormat(pattern="HH:mm")
    @Temporal(TemporalType.TIME)
    Date heureDepart;


    int nbrReservation;
    Boolean estValide;
    int nbPlaces;

    int prix;
    boolean accFumeurs;
    boolean accAnimaux;


    @JsonIgnore
    @ElementCollection
    private Set<PassagerTrajet> passerTrajet = new HashSet<PassagerTrajet>();


    public boolean isAccFumeurs() {
        return accFumeurs;
    }

    public void setAccFumeurs(boolean accFumeurs) {
        this.accFumeurs = accFumeurs;
    }

    public boolean isAccAnimaux() {
        return accAnimaux;
    }

    public void setAccAnimaux(boolean accAnimaux) {
        this.accAnimaux = accAnimaux;
    }


    @OneToMany(mappedBy = "primaryKey.trajet",
            cascade = CascadeType.REMOVE)
    public Set<PassagerTrajet> getPasserTrajet() {
        return passerTrajet;
    }



    public void setPasserTrajet(Set<PassagerTrajet> passerTrajet) {
        this.passerTrajet = passerTrajet;
    }

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "passage_id", referencedColumnName = "ID_passage")
    private Passage passage;

    @JsonIgnoreProperties("trajet")
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "admin_id", referencedColumnName = "id_admin")
    private Admin admin;



    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "villeD_id", referencedColumnName = "ID_vd")
    private VilleDepart villeD;


    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "villeA_id", referencedColumnName = "ID_va")
    private VilleArrivee villeA;



    @ManyToOne
    @JoinColumn(name = "conducteur_id", referencedColumnName = "ID_conducteur")
    private Conducteur conducteur;






    public Long getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(Long idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getNbrReservation() {
        return nbrReservation;
    }

    public void setNbrReservation(int nbrReservation) {
        this.nbrReservation = nbrReservation;
    }

    public Boolean getEstValide() {
        return estValide;
    }

    public void setEstValide(Boolean estValide) {
        this.estValide = estValide;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Passage getPassage() {
        return passage;
    }

    public void setPassage(Passage passage) {
        this.passage = passage;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public VilleDepart getVilleD() {

        return villeD;
    }

    public void setVilleD(VilleDepart villeD) {
        this.villeD = villeD;
    }

    public VilleArrivee getVilleA() {
        return villeA;
    }

    public void setVilleA(VilleArrivee villeA) {
        this.villeA = villeA;
    }


    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Conducteur getConducteur() {

      conducteur.setTrajetC(null);
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public Date getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Date heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void addUserGroup(PassagerTrajet passagerTrajet) {
        this.passerTrajet.add(passagerTrajet);
    }

}
