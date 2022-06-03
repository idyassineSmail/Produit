package com.example.produit;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.produit.ProduitRestController.ropos.UserRepository;
import com.example.produit.service.UserService;
import com.example.produit.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.produit.ProduitRestController.ropos.ProduitRopository;
import com.example.produit.prod.Produit;

@SpringBootTest
class ProduitApplicationTests {

    @Autowired
    private ProduitRopository produitRepository;

    @Autowired
    private UserService userService;
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("logo IRISI",4000.00,"C:\\Users\\ID YASSINE\\OneDrive\\Bureau\\logo\\128.png",new Date());
        produitRepository.save(prod);
    }
    @Test
    public void testCreateUser(){
        User user = new User("Smail","ID YASSIE","smail@gmail.com","123456789");
        userService.saveUser(user);
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
    public void testExsistanceUser(){
       boolean exsist1 = userService.getUserByEmailAndPassword("smail@gmail.com","123456789");
       System.out.println("exsist1 :  "+exsist1);
        boolean exsist2 = userService.getUserByEmailAndPassword("Sma","12356789");
        System.out.println("exsist2 :  "+exsist2);
        String token = UUID.randomUUID().toString().toLowerCase();
        System.out.println("tpken :  "+token);
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
