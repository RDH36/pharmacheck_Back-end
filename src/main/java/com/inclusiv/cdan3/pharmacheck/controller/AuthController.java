package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @PostMapping(path = "/inscription", consumes = "application/json")
    public boolean create(@RequestBody Utilisateur newUser, HttpServletRequest request) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(newUser.getEmail());
        Boolean response = false;
        if(matcher.matches()) {
            request.getSession().setAttribute("MAIL_USER", newUser.getEmail());
            serviceUtilisateur.saveUtilisateurWithAuth(newUser);
            response = true;
        }
        return  response;
    }
}
