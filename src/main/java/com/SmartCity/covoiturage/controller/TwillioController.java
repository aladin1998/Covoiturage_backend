package com.SmartCity.covoiturage.controller;

import com.SmartCity.covoiturage.ServiceSMS.TwillioService;
import com.SmartCity.covoiturage.model.Conducteur;
import com.SmartCity.covoiturage.model.Trajet;
import com.SmartCity.covoiturage.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TwillioController {



    @Autowired
    TwillioService twillioService;

    @Value("${app.twillio.fromPhoneNo}")
    private String from;

    @Value("${app.twillio.toPhoneNo}")
    private String to;

    @GetMapping("api/public/sendSms")
    public String sendSms() {

        String body = "Hello. Good Morning!!";
        twillioService.sendSms(to, from, body);
        return "message sent successfully";


    }





    @GetMapping("/makeCall")
    public String makeVoiceCall() {

        twillioService.makeCall(from, to);
        return "call initiated..";


    }






}

