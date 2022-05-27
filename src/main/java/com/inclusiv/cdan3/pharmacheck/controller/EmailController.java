package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.service.ServiceNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/email")
public class EmailController {
    @Autowired
    ServiceNotification serviceNotification;

    @GetMapping (path = "/sendNormal", consumes = "application/json")
    public boolean sendMail (@RequestParam("adresseMail") String mail, @RequestParam("subject") String subject, @RequestParam("text") String text) {
        if (serviceNotification.sendMailTo(mail, subject, text)) {
            return  true;
        } else {
            return false;
        }
    }
}
