package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class ProjetService implements IDao<Projet> {


    @Override
    public boolean create(Projet o) {
        Session session = null;
        Transaction tx = null;
        boolean etat = false;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
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
    public boolean delete(Projet o) {
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
    public boolean update(Projet o) {
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
    public Projet findById(int id) {
        Session session = null;
        Transaction tx = null;
        Projet projet = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet = (Projet) session.get(Projet.class, id);
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
        return projet;
    }

    @Override
    public List<Projet> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.createQuery("from Projet").list();
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
        return projets;
    }

    public List<Tache> findTaches(Projet projet){
        Session session = null;
        Transaction tx= null;
        List<Tache> taches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedQuery("findTaches").setParameter("projet", projet).list();
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
        return taches;
    }
    public List<EmployeTache> findTachesRealiseesAvecDatesReelles(Projet projet) {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> list = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            list = session.getNamedQuery("findTachesRealiseesByProjet")
                    .setParameter("projet", projet)
                    .list();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }

        return list;
    }
}
