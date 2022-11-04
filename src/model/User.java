package model;

public class User {
    private static int id = 1000;
    private String idUser;
    private String role = "member";
    private String name;
    private String username;
    private String password;


    public User() {
        this.idUser = "ID"+id++;
    }

    public User(String role, String name, String username, String password) {
        this.idUser = "ID"+id++;
        this.role = role;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password) {
        this.idUser = "ID"+id++;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override

    //chỉ xem id, userName, name
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                "\n";
    }
}
