package com.SmartCity.covoiturage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Data
@Table(name = "PASSAGER_TRAJET")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.passager",
                joinColumns = @JoinColumn(name = "PASSAGER_ID")),
        @AssociationOverride(name = "primaryKey.trajet",
                joinColumns = @JoinColumn(name = "TRAJET_ID")) })
public class PassagerTrajet {

    private PassagerTrajetId id=new PassagerTrajetId();



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PASSAGER_ID")
    private Passager passager;



    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "TRAJET_ID")
    private Trajet trajet;

    // additional fields
    @NotBlank
    private boolean activated;

    @Temporal(TemporalType.DATE)
    private Date registeredDate;

    @EmbeddedId
    public PassagerTrajetId getId() {
        return id;
    }

    public void setId(PassagerTrajetId id) {
        this.id = id;
    }
    @Transient
    public Trajet getTrajet() {
        return getId().getTrajet();
    }

    public void setTrajet(Trajet trajet) {
        getId().setTrajet(trajet);
    }

    @Transient
    public Passager getPassager() {
        return getId().getPassager();
    }

    public void setPassager(Passager passager) {
        getId().setPassager(passager);
    }



    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }
}
