package by.training.finalproject.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDAO <T, PK extends Serializable>{
    void create(T entity) throws DAOException;
    List<T> findAll() throws DAOException;
    T findById(PK id) throws DAOException;
    void update(T entity) throws DAOException;
    void delete(T entity) throws DAOException;

}
