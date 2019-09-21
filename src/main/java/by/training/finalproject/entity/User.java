package by.training.finalproject.entity;

public class User {
    private Integer userId;
    private String login;
    private String password;
    private String email;
    private String address;
    private String phone;
    private String firstName;
    private String lastName;
    private String photo = "https://icon-library.net/images/default-user-icon/default-user-icon-8.jpg";
    private Integer type = TypeOfUser.USER.getTypeOfUserId();

    public User() {
    }

    public User(String login, String password, String email, String address, String phone, String firstName, String lastName) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
