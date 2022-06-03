package com.example.produit.ProduitRestController.ropos;

import com.example.produit.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT a FROM User a WHERE a.email = ?1 AND a.passwd = ?2")
    User getUserByEmailAndPassword(String email, String passwd);

}
