package ma.projet.service;

import ma.projet.beans.Mariage;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MariageService implements IDao<Mariage> {

    @Override
    public boolean create(Mariage o) {
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
    public boolean update(Mariage o) {
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
    public boolean delete(Mariage o) {
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
    public Mariage findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Mariage.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Mariage> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Mariage", Mariage.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    // ✅ Demande: API Criteria -> nombre d'hommes mariés à 4 femmes entre deux dates
    public long nbHommesMarieAQuatreFemmesEntreDeuxDates(Date d1, Date d2) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
            Root<Mariage> m = cq.from(Mariage.class);

            // select homme.id
            cq.select(m.get("homme").get("id"));

            // where m.dateDebut between d1 and d2
            cq.where(cb.between(m.get("dateDebut"), d1, d2));

            // group by homme.id
            cq.groupBy(m.get("homme").get("id"));

            // having countDistinct(femme.id) = 4
            Expression<Long> nbFemmes = cb.countDistinct(m.get("femme").get("id"));
            cq.having(cb.equal(nbFemmes, 4L));

            List<Integer> hommesIds = session.createQuery(cq).getResultList();
            return hommesIds.size();
        }
    }

    // ✅ Demande: afficher les mariages d’un homme avec détails
    public List<Mariage> mariagesDunHomme(int hommeId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "from Mariage m where m.homme.id = :hid order by m.dateDebut asc",
                            Mariage.class)
                    .setParameter("hid", hommeId)
                    .getResultList();
        }
    }
}