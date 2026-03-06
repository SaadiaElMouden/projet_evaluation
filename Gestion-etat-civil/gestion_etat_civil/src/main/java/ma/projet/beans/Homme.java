package ma.projet.beans;

import javax.persistence.Entity;

@Entity
public class Homme extends Personne {
    public Homme() {}
    public Homme(String nom, String prenom, String telephone, String adresse, java.util.Date dateNaissance) {
        super(nom, prenom, telephone, adresse, dateNaissance);
    }
}