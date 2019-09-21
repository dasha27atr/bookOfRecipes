package by.training.finalproject.dao;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.dao.exception.UserDAOException;
import by.training.finalproject.entity.User;

public interface UserDAO extends AbstractDAO <User,Integer> {
    User findByLogin(String login) throws UserDAOException;
    User findByEmail(String email) throws UserDAOException;
    boolean existLogin(String login) throws UserDAOException;
}
