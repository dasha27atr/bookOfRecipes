package by.training.finalproject.entity;

import java.util.Date;

public class Recipe {
    private int recipeId;
    private String name;
    private String userLogin;
    public Date uploadDate;
    private int cathegoryId;

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }
}
