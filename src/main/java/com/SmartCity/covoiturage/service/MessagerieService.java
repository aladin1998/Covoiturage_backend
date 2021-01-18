package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.Messagerie;
import com.SmartCity.covoiturage.repository.messagerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagerieService {

    @Autowired
    private messagerieRepository messagerieR;

    public Messagerie saveMessagerie(Messagerie messagerie){
       return messagerieR.save(messagerie);
    }
   public List<Messagerie> saveMessageries(List<Messagerie> messageries){
        return messagerieR.saveAll(messageries);  }

        public List<Messagerie> getMessageries(){
        return messagerieR.findAll();
        }

        public Messagerie getMessagerieById(Long id){
        return messagerieR.findById(id).orElse(null);
        }

    public Messagerie updateMessagerie(Messagerie messagerie) {
          Messagerie existingMessagerie=messagerieR.findById(messagerie.getIdMessage()).orElse(null);
          return messagerieR.save(existingMessagerie);
    }
}
