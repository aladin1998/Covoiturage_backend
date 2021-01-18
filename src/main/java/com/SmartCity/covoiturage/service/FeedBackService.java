package com.SmartCity.covoiturage.service;


import com.SmartCity.covoiturage.model.FeedBack;
import com.SmartCity.covoiturage.repository.feedBackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {

    @Autowired
    private feedBackRepository feedBackR;

    public FeedBack saveFeedBack(FeedBack feedBack){
       return feedBackR.save(feedBack);
    }
   public List<FeedBack> saveFeedBack(List<FeedBack> feedBacks){
        return feedBackR.saveAll(feedBacks);  }

        public List<FeedBack> getFeedBacks(){
        return feedBackR.findAll();
        }

        public FeedBack getFeedBackById(Long id){
        return feedBackR.findById(id).orElse(null);
        }

    public FeedBack updateAdmin(FeedBack feedBack) {
          FeedBack existingAdmin=feedBackR.findById(feedBack.getIdFeed()).orElse(null);
          return feedBackR.save(existingAdmin);
    }
}
