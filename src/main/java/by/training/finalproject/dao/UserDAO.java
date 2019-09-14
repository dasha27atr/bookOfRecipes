package by.training.finalproject.dao;

import by.training.finalproject.entity.User;

import java.util.Optional;

public interface UserDAO extends AbstractDAO <User,Integer> {
    User findByLogin(String login) throws DAOException;
    User findByEmail(String email) throws DAOException;
    boolean existLogin(String login) throws DAOException;
}
