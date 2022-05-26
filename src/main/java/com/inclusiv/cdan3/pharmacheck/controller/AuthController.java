package com.inclusiv.cdan3.pharmacheck.controller;

import com.inclusiv.cdan3.pharmacheck.models.Utilisateur;
import com.inclusiv.cdan3.pharmacheck.service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    ServiceUtilisateur serviceUtilisateur;

    @PostMapping(path = "/inscription", consumes = "application/json")
    public Utilisateur inscription(@RequestBody Utilisateur newUser, HttpServletRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =pattern.matcher(newUser.getEmail());
        Boolean response = false;
        if(matcher.matches()) {
            serviceUtilisateur.saveUtilisateurWithAuth(newUser);
            request.getSession().setAttribute("MAIL_USER", newUser.getEmail());
            utilisateur = serviceUtilisateur.getUserByMAIl(newUser.getEmail());

        }
        return  utilisateur;
    }

    @PostMapping(path = "/connection", consumes = "application/json")
    public Utilisateur connection(@RequestBody Utilisateur newUser, HttpServletRequest request) {
        Utilisateur utilisateur = serviceUtilisateur.getUserByMAIl(newUser.getEmail());
        System.out.println(utilisateur.getMotDepasse() + " " + newUser.getMotDepasse() + " " +  utilisateur.getEmail() + " " +  newUser.getEmail());
        if(utilisateur.getMotDepasse().equals(newUser.getMotDepasse()) && utilisateur.getEmail().equals(newUser.getEmail())) {
            request.getSession().setAttribute("MAIL_USER", newUser.getEmail());
            request.getSession().setAttribute("ID_USER", utilisateur.getIdUtilisateur());
        } else {
            utilisateur = new Utilisateur();
        }
        System.out.println(request.getSession().getAttribute("MAIL_USER"));
        System.out.println(request.getSession().getAttribute("ID_USER"));
        return  utilisateur;
    }
}
