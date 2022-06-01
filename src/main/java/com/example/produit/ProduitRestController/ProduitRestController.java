package com.example.produit.ProduitRestController;

import com.example.produit.prod.Produit;
import com.example.produit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRestController {
    @Autowired
    ProduitService service;
    @RequestMapping("/lister")
//    @RequestMapping(method = RequestMethod.GET)
    public List<Produit> getAllProduits(){
        return service.getAllProduits();
    }

    @RequestMapping("/edit")
    public Produit getProduit(Long id){return service.getProduit(id);}
}
