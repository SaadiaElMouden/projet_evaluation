package ma.projet.service;

import ma.projet.classes.EmployeTache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class EmployeTacheService implements IDao<EmployeTache>
{
    @Override
    public boolean create(EmployeTache o) {
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
    public boolean delete(EmployeTache o) {
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
    public boolean update(EmployeTache o) {
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
    public EmployeTache findById(int id) {
        Session session = null;
        Transaction tx = null;
        EmployeTache employeTache = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTache = (EmployeTache) session.get(EmployeTache.class, id);
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
        return employeTache;
    }

    @Override
    public List<EmployeTache> findAll() {
        Session session = null;
        Transaction tx = null;
        List<EmployeTache> employeTaches = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTaches = session.createQuery("from EmployeTache").list();
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
        return employeTaches;
    }
}
