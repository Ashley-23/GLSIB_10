package com.example.tp1.repository;

import com.example.tp1.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

    @Modifying
    @Transactional
    @Query("update Produits p set p.qtStock =p.qtStock+:qte where p.id=:id")
    void updateQteProduit(@Param("id") int id, @Param("qte") int qte);

}
