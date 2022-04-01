package com.example.tp1.controller;

import com.example.tp1.modele.Approvisionnement;
import com.example.tp1.modele.Produit;
import com.example.tp1.service.ApprovisionnementService;
import com.example.tp1.service.CategorieService;
import com.example.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    ApprovisionnementService approvisionnementService;
    @Autowired
    ProduitService produitService;
    @Autowired
    CategorieService categorieService;


    @GetMapping("form")
    public  String ShowListProduit(Model model)
    {
        model.addAttribute("listProduit",produitService.showProduits());
        return ("approvisionnement/saveApprovisionnement");
    }

    @PostMapping("/save")
    public String saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnementService.saveApprovisionnement(approvisionnement);
        return "redirect:/produits/afficher";
    }

    @GetMapping("/approvisionner/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        System.out.println("id = "+produitService.showOneProduit(id));
        return "Approvisionnement/formApprovisionnement";
    }




}
