package model;

public class User {
    private static int id = 1000;
    private String idUser;
    private String role = "member";
    private String name;
    private String username;
    private String password;
    private String phoneNumber;


    public User(String role, String name, String username, String password, String phoneNumber) {
        this.role = role;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.idUser = "ID"+id++;
    }

    public User(String name, String username, String password, String phoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.idUser = "ID"+id++;
    }



    public String getIdUser() {
        return idUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }


    public String getUsername() {
        return username;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                "\n";
    }
}
