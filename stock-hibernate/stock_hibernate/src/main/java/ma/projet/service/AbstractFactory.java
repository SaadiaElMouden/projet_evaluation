package ma.projet.service;

import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
// ce classe est de but de céer les methodes une seul foi
public abstract  class AbstractFactory<T,ID extends Serializable> implements IDao<T,ID> {
    @Override
    public boolean create(T o) {
        Session session=null;
        Transaction tx=null;
        try{
            session= HibernateUtil.getSessionFactory().openSession();
            tx=session.beginTransaction();
            session.save(o);

        }
    }

    @Override
    public boolean delete(T o) {
        return false;
    }

    @Override
    public boolean update(T o) {
        return false;
    }

    @Override
    public T findById(ID id) {  // pour les methodes de reade on peut faire transaction ou pas
        return null;
    }

    @Override
    public List<T> findAll() {
        return Collections.emptyList();
    }
}
