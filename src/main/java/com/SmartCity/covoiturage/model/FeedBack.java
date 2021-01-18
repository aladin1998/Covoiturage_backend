package com.SmartCity.covoiturage.model;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class FeedBack {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long idFeed;
       private int avis;
       private String commentaire;

       public Long getIdFeed() {
              return idFeed;
       }

       public void setIdFeed(Long idFeed) {
              this.idFeed = idFeed;
       }

       public int getAvis() {
              return avis;
       }

       public void setAvis(int avis) {
              this.avis = avis;
       }

       public String getCommentaire() {
              return commentaire;
       }

       public void setCommentaire(String commentaire) {
              this.commentaire = commentaire;
       }
}
