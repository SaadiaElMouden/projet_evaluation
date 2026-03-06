package ma.projet.test;

import ma.projet.classes.*;
import ma.projet.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        EmployeService es = new EmployeService();
        ProjetService ps = new ProjetService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();

        // 1) Employé
        Employe e1 = new Employe("Alaoui", "Imane", "0600000000", null);
        es.create(e1);

        // 2) Projet
        Projet p1 = new Projet("Gestion Stock", sdf.parse("2025-01-01"), sdf.parse("2025-06-01"), e1);
        ps.create(p1);

        // 3) Taches (planifiées)
        Tache t1 = new Tache("Analyse", sdf.parse("2025-02-01"), sdf.parse("2025-02-10"), 1500.0,p1);

        ts.create(t1);

        Tache t2 = new Tache("Conception", sdf.parse("2025-03-01"), sdf.parse("2025-03-10"), 800.0,p1);

        ts.create(t2);

        // 4) Tâches réalisées (EmployeTache avec dates réelles)
        EmployeTache et1 = new EmployeTache(sdf.parse("2025-02-02"), sdf.parse("2025-02-08"), e1, t1);
        ets.create(et1);

        // =======================
        // TEST 1: prix > 1000
        System.out.println("Taches prix > 1000 :");
        for (Tache t : ts.findTachesPrixSup1000()) {
            System.out.println(t.getNom() + " : " + t.getPrix());
        }

        // TEST 2: réalisées entre 2 dates
        System.out.println("Taches realisees entre deux dates :");
        Date d1 = sdf.parse("2025-02-01");
        Date d2 = sdf.parse("2025-02-28");
        for (Tache t : ts.findTachesRealiseesEntreDeuxDates(d1, d2)) {
            System.out.println(t.getNom());
        }
    }
}