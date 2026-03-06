package ma.projet.classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String libelle;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Produit> produits;

    public Categorie() {
    }

    public Categorie(int id, String code, String libelle, List<Produit> produits) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.produits = produits;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
