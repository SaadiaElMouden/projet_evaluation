package ma.projet.service;


import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class EmployeService implements IDao<Employe> {
    @Override
    public boolean create(Employe o) {
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
    public boolean delete(Employe o) {
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
    public boolean update(Employe o) {
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
    public Employe findById(int id) {
        Session session = null;
        Transaction tx = null;
        Employe employe = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe)  session.get(Employe.class, id);
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
        return employe;
    }

    @Override
    public List<Employe> findAll() {
        Session session = null;
        Transaction tx = null;
        List<Employe> employes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
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
        return employes;
    }

    public List<Tache> findTchesEmploye(Employe employe){
        Session session = null;
        Transaction tx = null;
        List<Tache> taches = null;
        try{

            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches = session.getNamedQuery("findTachesEmploye").setParameter("employe",employe).list();
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
        return taches;
    }
    public List<Projet> findProjets(Employe employe){
        Session session = null;
        Transaction tx = null;
        List<Projet> projets = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets = session.getNamedQuery("findProjets").setParameter("employe",employe).list();
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
        return projets;
    }


}
