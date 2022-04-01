package com.example.tp1.service;

import com.example.tp1.modele.Approvisionnement;
import com.example.tp1.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    ApprovisionnementRepository approvisionnementRepository;

    public  void saveApprovisionnement(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showApprovisionnement(){
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement ShowOneApprovisionnement(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteApprovisionnement(int id){
        approvisionnementRepository.deleteById(id);
    }
}
