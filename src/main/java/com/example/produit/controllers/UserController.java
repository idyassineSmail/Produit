package com.example.produit.controllers;

import com.example.produit.ProduitRestController.ropos.UserRepository;
import com.example.produit.service.UserService;
import com.example.produit.user.User;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Base64;
import java.util.Locale;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public RedirectView getLoginView(){

        return new RedirectView("http://localhost/jee/login.php");
    }


    @RequestMapping("/signing")
    public RedirectView signing(@RequestParam("email") String email, @RequestParam("passwd") String passwd){
        String url;
        //vefication d'existance
        if(userService.getUserByEmailAndPassword(email,passwd)){
            //generate token
            //String email_passwd = email + passwd;

           // String token =   Base64.getEncoder().withoutPadding().encodeToString(email_passwd.getBytes());
            String token = UUID.randomUUID().toString().toLowerCase();
            System.out.println("votre token: " + token);
            url = "http://localhost/jee/lister.php?token="+token;
            //http POST

            //


        }else {
            url = "http://localhost/jee/login.php?login_err=already";
        }





        return new RedirectView(url);
    }
}