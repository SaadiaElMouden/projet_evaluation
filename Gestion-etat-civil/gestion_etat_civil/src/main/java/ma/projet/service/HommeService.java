package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HommeService implements IDao<Homme> {

    @Override
    public boolean create(Homme o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Homme o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Homme o) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    @Override
    public Homme findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Homme.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Homme> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Homme", Homme.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // ✅ Demande: afficher les épouses d’un homme entre deux dates
    public List<Femme> epousesEntreDeuxDates(int hommeId, Date d1, Date d2) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "select distinct m.femme from Mariage m " +
                                    "where m.homme.id = :hid and m.dateDebut between :d1 and :d2",
                            Femme.class)
                    .setParameter("hid", hommeId)
                    .setParameter("d1", d1)
                    .setParameter("d2", d2)
                    .getResultList();
        }
    }
}