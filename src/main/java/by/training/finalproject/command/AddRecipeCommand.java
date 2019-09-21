package by.training.finalproject.command;

import by.training.finalproject.dao.exception.RecipeDAOException;
import by.training.finalproject.dao.impl.RecipeDaoImpl;
import by.training.finalproject.entity.CategoriesOfRecipes;
import by.training.finalproject.entity.Recipe;
import by.training.finalproject.validator.Validator;
import by.training.finalproject.validator.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;

public class AddRecipeCommand implements Command {
    private static final RecipeDaoImpl recipeDao = new RecipeDaoImpl();
    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/errorAddRecipe.jsp";
        Validator validator = ValidatorFactory.getInstance().getAddRecipeValidator();
        try {
            if (!validator.validate(request)) {
                Recipe newRecipe = new Recipe();
                String title = request.getParameter("title");
                String photo;
                if (request.getParameter("photo") != null) {
                    photo = request.getParameter("photo");
                    newRecipe.setPhoto(photo);
                }
                String description = request.getParameter("description");
                CategoriesOfRecipes cathegoriesOfRecipes = CategoriesOfRecipes.valueOf(
                        request.getParameter("category").toUpperCase());
                newRecipe = new Recipe(title, description, cathegoriesOfRecipes.getCategoryId());
                recipeDao.create(newRecipe);
                page = "/jsp/account.jsp";
            }
        } catch (RecipeDAOException e) {
            //something
        }
        return page;
    }
}
