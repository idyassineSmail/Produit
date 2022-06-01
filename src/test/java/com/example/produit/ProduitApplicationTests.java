package com.example.produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.produit.ProduitRestController.ropos.ProduitRopository;
import com.example.produit.prod.Produit;

@SpringBootTest
class ProduitApplicationTests {

    @Autowired
    private ProduitRopository produitRepository;
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("logo IRISI",4000.00,"C:\\Users\\ID YASSINE\\OneDrive\\Bureau\\logo\\128.png",new Date());
        produitRepository.save(prod);
    }
    @Test
    public void testDeleteProduit() {
        produitRepository.deleteById(3L);
    }
    @Test
    public  void  testupdatedata() {
        Optional<Produit> produit = produitRepository.findById(3L);
        Produit produit1 = produit.get();
        produit1.setPrixProduit(2000.00);
        produitRepository.save(produit1);
    }
    @Test
    public void testListerTousProduits()
    {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }



}
