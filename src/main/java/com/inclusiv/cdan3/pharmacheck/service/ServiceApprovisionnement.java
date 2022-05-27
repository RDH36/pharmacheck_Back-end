package com.inclusiv.cdan3.pharmacheck.service;

import com.inclusiv.cdan3.pharmacheck.models.Approvisionnement;
import com.inclusiv.cdan3.pharmacheck.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceApprovisionnement {
    @Autowired
    ApprovisionnementRepository approvisionnementRepository;

    public List<Approvisionnement> getAllApprovisionement() {
        return  approvisionnementRepository.findAll();
    }

    public Approvisionnement addApprovisionement(Approvisionnement appr) {
        Approvisionnement approvisionnement;
        return  approvisionnementRepository.save(appr);
    }
}
