package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.service.ServiceNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin("*")
@RequestMapping("/email")
public class EmailController {
    @Autowired
    ServiceNotification serviceNotification;

    @GetMapping ("/sendNormal")
    public boolean sendMail (@RequestParam("adresseMail") String mail, @RequestParam("subject") String subject, @RequestParam("text") String text) {
        if (serviceNotification.sendMailTo(mail, subject, text)) {
            return  true;
        } else {
            return false;
        }
    }

    @GetMapping("/sendWithPdf")
    public void sendWithPdf (@RequestParam("adresseMail") String mail, @RequestParam("subject") String subject, @RequestParam("text") String text, @RequestParam("name") String name) throws MessagingException {
        serviceNotification.sendMailWithAttachement(mail, text, subject, "C:/Users/incli/Downloads/" + name + ".pdf");
    }
}
