package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;


import java.util.Date;
import java.util.List;

public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session=HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            etat = true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return etat;
    }

    @Override
    public Produit findById(int id) {
        Session session = null;
        Transaction tx = null;
        Produit produit = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produits;
    }

    public List<Produit> findByCategorie(Categorie categorie){
        Session session = null;
        Transaction tx= null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.getNamedQuery("findByCategorie").setParameter("categorie", categorie).list();
            tx.commit();

        }
        catch (HibernateException e){
            if(tx!=null){
                tx.rollback();

            }

        }
        finally{
            if (session != null){
                session.close();
            }
        }
        return produits;
    }
    public List<Produit> produitsEntreDates(Date d1, Date d2){
Session session = null;
Transaction tx = null;
List<Produit> produits = null;
try {
    session = HibernateUtil.getSessionFactory().openSession();
    tx = session.beginTransaction();
    produits = session.getNamedQuery("produitsEntreDates")
            .setParameter("d1",d1)
            .setParameter("d2",d2)
            .list();
    tx.commit();
}
catch ( HibernateException e){
    if (tx != null){
        tx.rollback();
    }

}
finally {
    if (session !=null){
        session.close();
    }
}
return produits;
    }
    public List<Produit> findByCommande(Commande commande){
Session session = null;
Transaction tx = null;
List<Produit> produits = null;
try{
    session = HibernateUtil.getSessionFactory().openSession();
    tx = session.beginTransaction();
    produits = session.getNamedQuery("findByCommande").setParameter("commande",commande).list();
    tx.commit();

}
catch (HibernateException e){
    if (tx != null){
        tx.rollback();
    }
}
finally {
    if (session != null){
        session.close();
    }

}
        return produits;
    }
    public List<Produit> findProduitsSup100(){
        Session session = null;
        Transaction tx = null;
        List<Produit> produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.getNamedQuery("findProduitsSup100").list();
            tx.commit();
        }
        catch (HibernateException e){
            if (tx!= null){
                tx.rollback();
            }
        }
        finally {
            if (session != null){
                session.close();
            }
        }
        return produits;
    }

}

