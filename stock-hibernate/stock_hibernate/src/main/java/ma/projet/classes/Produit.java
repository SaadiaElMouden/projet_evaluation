package ma.projet.classes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Produit")
@NamedQuery(name="findProduitsSup100",query="from Produit p where p.prix>100")
@NamedQuery(name="findByCommande",query="select distinct l.produit from LigneCommandeProduit l where l.commande=:commande")
@NamedQuery(name="produitsEntreDates",query="select distinct l.produit from LigneCommandeProduit l where l.commande.date between :d1 and :d2")
@NamedQuery(name = "findByCategorie", query = "from Produit where categorie =:categorie")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private float prix;
    @ManyToOne //(par defaut EGGER

    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    private List<LigneCommandeProduit> ligneCommandeProduits;

    public Produit(int id, String reference, float prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
