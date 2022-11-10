package model;

public class Admin extends User{
    public Admin(String name, String username, String password, String phoneNumber) {
        super(name, username, password, phoneNumber);
        super.setRole("admin");
    }
}
