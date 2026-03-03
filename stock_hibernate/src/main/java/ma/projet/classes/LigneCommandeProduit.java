package ma.projet.classes;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommandeProduit {
    @EmbeddedId
    private CommandeProduitPK pk;
    private int quantite;
    @ManyToOne
    @JoinColumn(name = "produit", referencedColumnName = "id", insertable = false, updatable = false) //sans resferenceColumnName il faut donner le meme non de id de classe
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande", referencedColumnName = "id", insertable = false, updatable = false)
    private Commande commande;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(CommandeProduitPK pk, int quantite, Produit produit, Commande commande) {

        this.quantite = quantite;
        this.produit = produit;
        this.commande = commande;
        pk = new CommandeProduitPK(commande.getId(), produit.getId());
    }

    public CommandeProduitPK getPk() {
        return pk;
    }

    public void setPk(CommandeProduitPK pk) {
        this.pk = pk;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }



}
