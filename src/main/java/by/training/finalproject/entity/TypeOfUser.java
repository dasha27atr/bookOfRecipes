package by.training.finalproject.entity;

public enum TypeOfUser {
    VISITER("visiter"), CLIENT("client"), ADMINISTRATOR("administrator");

    private String type;

    TypeOfUser(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
