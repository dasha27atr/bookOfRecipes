package by.training.finalproject.test.dao;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.test.entity.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {
    //create
    void add(Address address) throws DAOException;
    //read
    List<Address> findAll() throws DAOException;
    Address findById(Long id) throws DAOException;
    //update
    void update(Address address) throws DAOException;
    //delete
    void remove(Address address) throws DAOException;
}
