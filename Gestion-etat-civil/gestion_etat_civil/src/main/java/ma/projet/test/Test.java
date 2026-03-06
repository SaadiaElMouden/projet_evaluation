package ma.projet.test;

import ma.projet.beans.*;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.MariageService;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    private static Date d(String s) throws Exception {
        return new SimpleDateFormat("dd/MM/yyyy").parse(s);
    }

    public static void main(String[] args) throws Exception {

        HommeService hommeService = new HommeService();
        FemmeService femmeService = new FemmeService();
        MariageService mariageService = new MariageService();

        // 1) Créer 10 femmes et 5 hommes
        List<Homme> hommes = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Homme h = new Homme("Homme" + i, "PrenomH" + i, "06-0000" + i, "AdresseH" + i, d("01/01/198" + i));
            hommeService.create(h);
            hommes.add(h);
        }

        List<Femme> femmes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Femme f = new Femme("Femme" + i, "PrenomF" + i, "07-0000" + i, "AdresseF" + i, d("01/01/197" + (i % 10)));
            femmeService.create(f);
            femmes.add(f);
        }

        // 2) Afficher la liste des femmes
        System.out.println("Liste des femmes:");
        femmeService.findAll().forEach(System.out::println);

        // 3) Afficher la femme la plus âgée
        Femme plusAgee = femmeService.femmeLaPlusAgee();
        System.out.println("\nFemme la plus âgée: " + plusAgee);

        // 4) Créer des mariages (exemples)
        // Homme1 marié à 4 femmes entre deux dates (pour tester Criteria)
        Homme h1 = hommes.get(0);
        mariageService.create(new Mariage(h1, femmes.get(0), d("03/09/1990"), d("03/09/1992"), 4));
        mariageService.create(new Mariage(h1, femmes.get(1), d("03/09/1995"), d("03/09/1997"), 2));
        mariageService.create(new Mariage(h1, femmes.get(2), d("04/11/2000"), d("04/11/2002"), 3));
        mariageService.create(new Mariage(h1, femmes.get(3), d("10/02/2005"), d("10/02/2008"), 1));

        // Femme5 mariée 2 fois (pour tester "mariée au moins deux fois")
        mariageService.create(new Mariage(hommes.get(1), femmes.get(4), d("01/01/2010"), d("01/01/2012"), 0));
        mariageService.create(new Mariage(hommes.get(2), femmes.get(4), d("01/01/2014"), d("01/01/2016"), 1));

        // 5) Afficher les épouses d’un homme donné
        System.out.println("\nEpouses de " + h1 + " entre 01/01/1980 et 01/01/2010:");
        hommeService.epousesEntreDeuxDates(h1.getId(), d("01/01/1980"), d("01/01/2010"))
                .forEach(System.out::println);

        // 6) Nombre d’enfants d’une femme entre deux dates (native named query)
        Femme f5 = femmes.get(4);
        long nbEnfantsF5 = femmeService.nbEnfantsEntreDeuxDates(f5.getId(), d("01/01/2000"), d("01/01/2020"));
        System.out.println("\nNombre d'enfants de " + f5 + " entre 2000 et 2020: " + nbEnfantsF5);

        // 7) Femmes mariées 2 fois ou plus (named query)
        System.out.println("\nFemmes mariées au moins deux fois:");
        femmeService.femmesMarieesAuMoinsDeuxFois().forEach(System.out::println);

        // 8) Hommes mariés à 4 femmes entre deux dates (Criteria API)
        long nbHommes = mariageService.nbHommesMarieAQuatreFemmesEntreDeuxDates(d("01/01/1980"), d("01/01/2010"));
        System.out.println("\nNombre d'hommes mariés à 4 femmes entre 1980 et 2010: " + nbHommes);

        // 9) Afficher les mariages d’un homme avec détails
        System.out.println("\nNom : " + h1.getNom() + " " + h1.getPrenom());
        System.out.println("Mariages En Cours :");
        List<Mariage> mariages = mariageService.mariagesDunHomme(h1.getId());
        int i = 1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Mariage m : mariages) {
            System.out.println(i++ + ". Femme : " + m.getFemme().getNom() + " " + m.getFemme().getPrenom() +
                    "   Date Début : " + sdf.format(m.getDateDebut()) +
                    "   Nbr Enfants : " + m.getNbrEnfant());
        }
    }
}