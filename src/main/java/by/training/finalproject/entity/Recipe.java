package by.training.finalproject.entity;

import java.sql.Date;
import java.util.Calendar;

public class Recipe {
    private Integer recipeId;
    private String title;
    private String userLogin = "a";
    private Date uploadDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    private String photo = "https://icon-library.net/images/img-icon/img-icon-11.jpg";
    private String description;
    private Integer categoryId = CategoriesOfRecipes.UNKNOWN.getCategoryId();

    public Recipe() {
    }

    public Recipe(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Recipe(String title, String description, Integer categoryId) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Recipe(String title, String photo, String description) {
        this.title = title;
        this.photo = photo;
        this.description = description;
    }

    public Recipe(String title, String photo, String description, Integer categoryId) {
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
