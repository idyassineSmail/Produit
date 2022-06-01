package com.example.produit.service;

import com.example.produit.prod.Produit;
import com.example.produit.ProduitRestController.ropos.ProduitRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRopository produitRopository;

    @Override
    public Produit saveProduit(Produit p) {
        return produitRopository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p) {return produitRopository.save(p); }

    @Override
    public void deleteProduit(Produit p) {
        produitRopository.delete(p);
    }
    @Override
    public void deleteProduitById(Long id) {
        produitRopository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRopository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRopository.findAll();
    }

    @Override
    public void saveImage(MultipartFile image) throws IOException {
        String folder = "C:\\xampp\\htdocs\\jee\\images\\";
        byte[] bytes = image.getBytes();
        String name = image.getOriginalFilename();
        Path path = Paths.get(folder + name);
        Files.write(path, bytes);
        System.out.println("dons la fonction");
    }
}
