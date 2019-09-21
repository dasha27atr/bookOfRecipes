package by.training.finalproject.test.dao;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.test.entity.Project;

import java.util.List;

public interface ProjectDAO {
    //create
    void add(Project project) throws DAOException;
    //read
    List<Project> findAll() throws DAOException;
    Project findById(Long id) throws DAOException;
    //update
    void update(Project project) throws DAOException;
    //delete
    void remove(Project project) throws DAOException;
}
