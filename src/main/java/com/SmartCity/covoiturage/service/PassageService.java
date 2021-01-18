package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.Passage;
import com.SmartCity.covoiturage.repository.passageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassageService {

    @Autowired
    private passageRepository passageR;

    public Passage savePassage(Passage passage){
       return passageR.save(passage);
    }

   public List<Passage> savePassages(List<Passage> passages){
        return passageR.saveAll(passages);  }

        public List<Passage> getPassages(){
        return passageR.findAll();
        }

        public Passage getPassageById(Long id){
        return passageR.findById(id).orElse(null);
        }

    public Passage updatePassage(Passage passage) {
          Passage existingPassage=passageR.findById(passage.getIdPassage()).orElse(null);
          return passageR.save(existingPassage);
    }
}
