package com.example.produit.controllers;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.produit.prod.Produit;
import com.example.produit.service.ProduitService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProduitController {
    @Autowired
    ProduitService produitService;
    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createProduit";
    }

    @RequestMapping("/image")
    public String returnImage(){ return "image"; }



    @RequestMapping("/saveProduit")
    public String saveProduit(@ModelAttribute("produit") Produit produit,
                              @RequestParam("date") String date,
                              ModelMap modelMap) throws ParseException
    {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date)); produit.setDateCreation(dateCreation);
        Produit saveProduit = produitService.saveProduit(produit);
        String msg ="produit enregistré avec Id "+saveProduit.getIdProduit();
        modelMap.addAttribute("msg", msg);
        return "createProduit";
    }


    //pour PHP
    @PostMapping("/ajouterProduit")
    public RedirectView ajouterProduit(@ModelAttribute("produit") Produit produit,
                                       @RequestParam("date") String date,
                                       @RequestParam("image") MultipartFile image) throws ParseException
    {
        // upload image
        try {
            produitService.saveImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        produit.setImageProduit(image.getOriginalFilename());

        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        produit.setDateCreation(dateCreation);
        Produit saveProduit = produitService.saveProduit(produit);
        String msg ="produit enregistre avec Id "+saveProduit.getIdProduit();
        RedirectView ajouterPHP = new RedirectView("http://localhost/jee/form.php?message="+msg);
        return ajouterPHP;
    }
    @RequestMapping("/ListeProduits")
    public String listeProduits(ModelMap modelMap)
    {
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "listeProduits";
    }
    @RequestMapping("/supprimerProduit")
    public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap)
    {
        produitService.deleteProduitById(id);
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "listeProduits";
    }

    //pour PHP
    @RequestMapping("/deleteProduit")
    public RedirectView deleteProduit(@RequestParam("id") Long id, ModelMap modelMap)
    {
        produitService.deleteProduitById(id);
        RedirectView listerPHP = new RedirectView("http://localhost/jee/lister.php");
        return listerPHP;
    }
    @RequestMapping("/modifierProduit")
    public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Produit p= produitService.getProduit(id);
        modelMap.addAttribute("produit", p);
        return "editerProduit";
    }

    @RequestMapping("/updateProduit")
    public String updateProduit(@ModelAttribute("produit") Produit produit,@RequestParam("date") String date, ModelMap modelMap) throws ParseException
    {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        produit.setDateCreation(dateCreation);
        produitService.updateProduit(produit);
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "listeProduits";
    }


    //pour PHP
    @PostMapping("/modifierProduitPHP")
    public RedirectView modifierProduitPHP(@ModelAttribute("produit") Produit produit, @RequestParam("date")
            String date,@RequestParam("image") MultipartFile image, ModelMap modelMap) throws ParseException {

        // upload image
        System.out.println("before try");
        try {
            produitService.saveImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("after try");
        produit.setImageProduit(image.getOriginalFilename());

//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        produit.setDateCreation(dateCreation);
        produitService.saveProduit(produit);
        System.out.println("after produit repos");
        String msg = "produit modifier avec succee";
        RedirectView listerPHP = new RedirectView("http://localhost/jee/lister.php?message=" + msg);
        return listerPHP;
    }
}
