package by.training.finalproject.test.dao;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.test.entity.EmplProj;

import java.util.List;

public interface EmplProjDAO {
    //create
    void add(EmplProj emplProj) throws DAOException;
    //read
    List<EmplProj> findAll() throws DAOException;
    EmplProj findByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws DAOException;
    //update
    void update(EmplProj emplProj) throws DAOException;
    //delete
    void remove(EmplProj emplProj) throws DAOException;
}
