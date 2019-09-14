package by.training.finalproject.dao;

import by.training.finalproject.entity.Recipe;

import java.util.Date;
import java.util.List;

public interface RecipeDAO extends AbstractDAO<Recipe, Integer> {
    List<Recipe> findHotDishes();
    List<Recipe> findSalads();
    List<Recipe> findSnacks();
    List<Recipe> findSoups();
    List<Recipe> findBaking();
    List<Recipe> findDesserts();
    List<Recipe> findDrinks();
    List<Recipe> findByUploadDate(Date uploadDate);
    List<Recipe> findByUser(String user);
}
