package by.training.finalproject.validator;

import by.training.finalproject.dao.exception.RecipeDAOException;
import by.training.finalproject.dao.impl.RecipeDaoImpl;
import by.training.finalproject.entity.CategoriesOfRecipes;

import javax.servlet.http.HttpServletRequest;

public class AddRecipeValidator implements Validator {
    private static final RecipeDaoImpl recipeDao = new RecipeDaoImpl();

    @Override
    public boolean validate(HttpServletRequest request) {
        boolean exist = true;
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        CategoriesOfRecipes categoriesOfRecipes = CategoriesOfRecipes.valueOf(
                request.getParameter("category").toUpperCase());

        if (title != null && description != null &&
                categoriesOfRecipes.getCategoryId() != 0) {
            try {
                if (!recipeDao.existTitle(title)) {
                    exist = false;
                }
            } catch (RecipeDAOException e) {
                //something?
            }
        }
        return exist;
    }
}
