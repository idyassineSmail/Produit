package com.example.produit.service;

import com.example.produit.ProduitRestController.ropos.UserRepository;
import com.example.produit.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean getUserByEmailAndPassword(String email, String passwd) {
        User user = userRepository.getUserByEmailAndPassword(email,passwd);
        boolean exsist = true;
        if(user == null){
            exsist = false;
        }
        return exsist ;
    }

}
