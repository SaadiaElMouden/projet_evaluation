package ma.projet.test;

import ma.projet.classes.Categorie;
import ma.projet.service.CategorieService;

import java.util.List;

public class TestCategorie {
    public static void main(String[] args) {
        CategorieService cs = new CategorieService();

        Categorie c1 = new Categorie();
        c1.setCode("C1");
        c1.setLibelle("Informatique");

        Categorie c2 = new Categorie();
        c2.setCode("C2");
        c2.setLibelle("Electronique"); // crée les objets java

        cs.create(c1); // transforme les objets java en tables
        cs.create(c2);


        System.out.println("=== Toutes les catégories ===");
        List<Categorie> cats = cs.findAll();
        cats.forEach(c -> System.out.println(c.getId() + " | " + c.getCode() + " | " + c.getLibelle()));

        System.out.println("=== Update catégorie C1 ===");
        c1.setLibelle("Info (Updated)");
        cs.update(c1);
        System.out.println("C1 après update: " + cs.findById(c1.getId()).getLibelle());

        System.out.println("=== Delete catégorie C2 ===");
        cs.delete(c2);
        System.out.println("C2 après delete: " + cs.findById(c2.getId()));
    }
}