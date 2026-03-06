package ma.projet.beans;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Femme.marieeAuMoinsDeuxFois",
                query = "SELECT f FROM Femme f WHERE (SELECT COUNT(m) FROM Mariage m WHERE m.femme = f) >= 2"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Femme.nbEnfantsEntreDeuxDates",
                query = "SELECT COALESCE(SUM(m.nbrEnfant),0) " +
                        "FROM Mariage m " +
                        "WHERE m.femme_id = :femmeId AND m.dateDebut BETWEEN :d1 AND :d2"
        )
})
public class Femme extends Personne {
    public Femme() {}
    public Femme(String nom, String prenom, String telephone, String adresse, java.util.Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }
}