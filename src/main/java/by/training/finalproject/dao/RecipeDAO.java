package by.training.finalproject.dao;

import by.training.finalproject.dao.exception.RecipeDAOException;
import by.training.finalproject.entity.Recipe;

import java.util.Date;
import java.util.List;

public interface RecipeDAO extends AbstractDAO<Recipe, Integer> {
    List<Recipe> findHotDishes() throws RecipeDAOException;
    List<Recipe> findSalads() throws RecipeDAOException;
    List<Recipe> findSnacks() throws RecipeDAOException;
    List<Recipe> findSoups() throws RecipeDAOException;
    List<Recipe> findBaking() throws RecipeDAOException;
    List<Recipe> findDesserts() throws RecipeDAOException;
    List<Recipe> findDrinks() throws RecipeDAOException;
    List<Recipe> findByLogin(String login) throws RecipeDAOException;
    boolean existTitle(String title) throws RecipeDAOException;
}
