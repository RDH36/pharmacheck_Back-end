package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @PostMapping(path = "/inscription", consumes = "application/json")
    public boolean inscription(@RequestBody Utilisateur newUser, HttpServletRequest request) {
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

    @PostMapping(path = "/connection", consumes = "application/json")
    public boolean connection(@RequestBody Utilisateur newUser, HttpServletRequest request) {
        Utilisateur utilisateur = serviceUtilisateur.getUserByMAIl(newUser.getEmail());
        System.out.println(utilisateur.getMotDepasse() + " " + newUser.getMotDepasse() + " " +  utilisateur.getEmail() + " " +  newUser.getEmail());
        Boolean response = false;
        if(utilisateur.getMotDepasse().equals(newUser.getMotDepasse()) && utilisateur.getEmail().equals(newUser.getEmail())) {
            request.getSession().setAttribute("MAIL_USER", newUser.getEmail());
            response = true;
        }
        System.out.println(request.getSession().getAttribute("MAIL_USER"));
        return  response;
    }
}
