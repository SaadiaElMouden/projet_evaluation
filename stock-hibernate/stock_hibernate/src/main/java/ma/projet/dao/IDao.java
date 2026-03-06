package ma.projet.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author X1 YOGA
 */
public interface IDao<T,ID extends Serializable> { // T est un classe generique

    boolean create(T o);

    boolean delete(T o);

    boolean update(T o);

    T findById(ID id); // on a fait ID cer on a aussi un id de type PK

    List<T> findAll();

}