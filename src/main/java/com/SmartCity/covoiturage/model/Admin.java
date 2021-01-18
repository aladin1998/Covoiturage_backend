package com.SmartCity.covoiturage.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_admin")
    private Long idAdmin;

    private String nomAdmin;
    private String login;
    private String password;

    @JsonIgnoreProperties("admin")
    @OneToMany(mappedBy = "admin")
    List<Trajet> trajet=new ArrayList<>();

    public Long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Trajet> getTrajet() {
        return trajet;
    }

    public void setTrajet(List<Trajet> trajet) {
        this.trajet = trajet;
    }
}
