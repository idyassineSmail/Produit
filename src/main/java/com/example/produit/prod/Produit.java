package com.example.produit.prod;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private String imageProduit;
    private Date dateCreation;
    public Produit() {
        super();
    }

    public Produit(String nomProduit, Double prixProduit, String imageProduit, Date dateCreation) {
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.imageProduit = imageProduit;
        this.dateCreation = dateCreation;
    }

    public Long getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Double getPrixProduit() {
        return prixProduit;
    }
    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getImageProduit() {return imageProduit;}
    public void setImageProduit(String imageProduit) {this.imageProduit = imageProduit;}

    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    @Override
    public String toString() {
        return "Produit [idProduit = " + idProduit + ", nomProduit = " + nomProduit + ", prixProduit = " + prixProduit
                + ", imageProduit: " +imageProduit+ ", dateCreation = " + dateCreation + "]";
    }

}
