package com.example.tp1.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produits")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String libelle;
    private int qtStock;
    private int qtSeuil;
    private int prix;
    private LocalDate dateCreation;
    @ManyToOne()
    @JoinColumn(name = "categorieId", insertable = false, updatable = false)
    private Categorie categorie;
    private int categorieId;
}
