package by.training.finalproject.entity;

public enum CategoriesOfRecipes {
    UNKNOWN(0), HOT_DISHES(1), SALADS(2), SNACKS(3), SOUPS(4),
    BAKING(5), DESSERTS(6), DRINKS(7);

    private Integer categoryId;

    CategoriesOfRecipes(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
