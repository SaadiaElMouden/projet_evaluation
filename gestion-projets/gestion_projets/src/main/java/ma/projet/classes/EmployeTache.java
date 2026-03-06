package ma.projet.classes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EmployeTache")
@NamedQuery(
        name = "findTachesRealiseesByProjet",
        query = "from EmployeTache et where et.tache.projet = :projet")
@NamedQuery(name="findTachesEmploye",query="from EmployeTache et where et.employe=:employe")
@NamedQuery(name="findProjets",query="from Projet p where p.employe=:employe")
public class EmployeTache {
    @EmbeddedId
    private EmployeTachePK pk;
    @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;
    @Temporal(TemporalType.DATE)
    private Date dateFinReelle;
    @ManyToOne
    @JoinColumn(name = "employe",referencedColumnName = "id",insertable = false,updatable = false)

    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "tache",referencedColumnName = "id",insertable = false,updatable = false)
    private Tache tache;

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutReelle, Date dateFinReelle, Employe employe, Tache tache) {
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.employe = employe;
        this.tache = tache;
        pk = new EmployeTachePK(employe.getId(), tache.getId());
    }

    public EmployeTachePK getPk() {
        return pk;
    }

    public void setPk(EmployeTachePK pk) {
        this.pk = pk;
    }

    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }
}

