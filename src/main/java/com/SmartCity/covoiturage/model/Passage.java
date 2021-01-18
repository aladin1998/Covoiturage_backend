package com.SmartCity.covoiturage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="passage")
@Data
public class Passage  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_passage")
    private Long idPassage;

    @JsonIgnoreProperties("passages")
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(

            name = "passage_ville",
            joinColumns = @JoinColumn(name = "passage_id"),
            inverseJoinColumns = @JoinColumn(name = "ville_id")
    )
    private List<Ville> villes=new ArrayList<>();

    @JsonIgnoreProperties("passage")
    @OneToOne(mappedBy = "passage")
    private Trajet trajet;



    public Long getIdPassage() {
        return idPassage;
    }

    public void setIdPassage(Long idPassage) {
        this.idPassage = idPassage;
    }

}
