package ma.projet.service;

import ma.projet.beans.Femme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FemmeService implements IDao<Femme> {

    @Override
    public boolean create(Femme o) {
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
    public boolean update(Femme o) {
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
    public boolean delete(Femme o) {
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
    public Femme findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Femme.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Femme> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Femme", Femme.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // ✅ femme la plus âgée = dateNaissance la plus ancienne
    public Femme femmeLaPlusAgee() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Femme f order by f.dateNaissance asc", Femme.class)
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }

    // ✅ Demande: requête native nommée -> nombre d'enfants d'une femme entre deux dates
    public long nbEnfantsEntreDeuxDates(int femmeId, Date d1, Date d2) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Object res = session.getNamedQuery("Femme.nbEnfantsEntreDeuxDates")
                    .setParameter("femmeId", femmeId)
                    .setParameter("d1", d1)
                    .setParameter("d2", d2)
                    .uniqueResult();
            return (res == null) ? 0 : ((Number) res).longValue();
        }
    }

    // ✅ Demande: requête nommée -> femmes mariées au moins deux fois
    public List<Femme> femmesMarieesAuMoinsDeuxFois() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createNamedQuery("Femme.marieeAuMoinsDeuxFois", Femme.class).getResultList();
        }
    }
}