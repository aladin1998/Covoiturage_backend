package com.SmartCity.covoiturage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="passager")
@Data
public class Passager  {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_passger")
    private Long idPassager;

    @ElementCollection
    private Set<PassagerTrajet> passerTrajet = new HashSet<PassagerTrajet>();


    @JsonIgnoreProperties("passager")
    @OneToMany(mappedBy="passager")
    private List<Messagerie> msgrsP=new ArrayList<>();


   @JsonManagedReference(value = "utilisateur")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public void addPT(PassagerTrajet PT){
        this.passerTrajet.add(PT);
    }
    public Long getIdPassager() {
        return idPassager;
    }

    public void setIdPassager(Long idPassager) {
        this.idPassager = idPassager;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "primaryKey.group",
            cascade = CascadeType.ALL)
    public Set<PassagerTrajet> getPasserTrajet() {
        return passerTrajet;
    }

    public void setPasserTrajet(Set<PassagerTrajet> passerTrajet) {
        this.passerTrajet = passerTrajet;
    }

    public List<Messagerie> getMsgrsP() {
        return msgrsP;
    }

    public void setMsgrsP(List<Messagerie> msgrsP) {
        this.msgrsP = msgrsP;
    }

    public Utilisateur getUtilisateurP() {
        return utilisateur;
    }

    public void setUtilisateurP(Utilisateur utilisateurP) {
        this.utilisateur = utilisateurP;
    }

    public List<Messagerie> getMsgs() {
        return msgrsP;
    }

    public void setMsgs(List<Messagerie> msgs) {
        this.msgrsP = msgs;
    }

}
