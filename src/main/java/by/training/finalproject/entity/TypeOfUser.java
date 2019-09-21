package by.training.finalproject.entity;

public enum TypeOfUser {
    USER(1), ADMINISTRATOR(2);

    private Integer typeOfUserId;

    TypeOfUser(Integer typeOfUserId) {
        this.typeOfUserId = typeOfUserId;
    }

    public Integer getTypeOfUserId() {
        return typeOfUserId;
    }

    public void setTypeOfUserId(Integer typeOfUserId) {
        this.typeOfUserId = typeOfUserId;
    }
}
