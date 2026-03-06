package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tache")
@NamedQuery(name="findTaches",query="from Tache t where t.projet=:projet")
@NamedQuery(name = "findTachesPrixSup1000",query = "from Tache t where t.prix > 1000")

@NamedQuery(name = "findTachesRealiseesEntreDates", query = "select distinct et.tache from EmployeTache et " + "where et.dateDebutReelle between :d1 and :d2")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private Double prix;
    @ManyToOne
    private Projet projet;

    public Tache() {
    }

    public Tache(String nom, Date dateDebut, Date dateFin, Double prix,Projet projet) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        this.projet=projet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
