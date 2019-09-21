package by.training.finalproject.test.dao;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.test.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //create
    void add(Employee employee) throws DAOException;
    //read
    List<Employee> findAll() throws DAOException;
    Employee findById(Long id) throws DAOException;
    //update
    void update(Employee employee) throws DAOException;
    //delete
    void remove(Employee employee) throws DAOException;
}
