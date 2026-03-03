package ma.projet.test;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CategorieService;
import ma.projet.service.CommandeService;
import ma.projet.service.LigneCommandeService;
import ma.projet.service.ProduitService;

import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        CommandeService cms = new CommandeService();
        LigneCommandeService lcs = new LigneCommandeService();
        //Categorie
        Categorie c1 = new Categorie();
        c1.setCode("C1");
        c1.setLibelle("Informatique");

        Categorie c2 = new Categorie();
        c2.setCode("C2");
        c2.setLibelle("Electronique");

        cs.create(c1);
        cs.create(c2);

      //produits
        Produit p1 =new Produit();
        p1.setReference("P1");
        p1.setPrix(200);
        p1.setCategorie(c1);

        Produit p2 = new Produit();
        p2.setReference("P2");
        p2.setPrix(50);
        p2.setCategorie(c2);

        Produit p3 = new Produit();
        p3.setReference("P3");
        p3.setPrix(300);
        p3.setCategorie(c2);

        ps.create(p1);
        ps.create(p2);
        ps.create(p3);

        //Commandes

        Commande cmd = new Commande();
        cmd.setDate(new Date());
        cms.create(cmd);

        //Lignes de commande

        LigneCommandeProduit l1 = new LigneCommandeProduit();
        LigneCommandeProduit l2 = new LigneCommandeProduit();

        lcs.create(l1);
        lcs.create(l2);

        //test

        System.out.println("Produits par categorie C1:");
        List<Produit> produitsCat = ps.findByCategorie(c1);
        produitsCat.forEach(p-> System.out.println(p.getReference()));

        System.out.println("Produits entre deux dates: ");
        List<Produit> produitsDates = ps.produitsEntreDates(new Date(0),new Date());
        produitsDates.forEach(p-> System.out.println(p.getReference()));

        System.out.println("Produits d'une commande");
        List<Produit> produitsCmd = ps.findByCommande(cmd);
        produitsCmd.forEach(p-> System.out.println(p.getReference()));

        System.out.println("Produits avec prix > 100");
        List<Produit> sup100 = ps.findProduitsSup100();
        sup100.forEach(p-> System.out.println(p.getReference() + ":" +p.getReference()));


    }
}
