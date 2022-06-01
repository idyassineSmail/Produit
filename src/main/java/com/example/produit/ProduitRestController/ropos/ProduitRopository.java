package com.example.produit.ProduitRestController.ropos;
import com.example.produit.prod.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProduitRopository extends JpaRepository<Produit, Long> {
}
