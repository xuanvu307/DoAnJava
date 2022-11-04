package control;

import model.User;
import model.UserModel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserModel userModel = new UserModel();
        ArrayList<User> users = new ArrayList<>();
        User admin = new User("admin","admin","admin","123");
        User mem = new User("member","admin","mem","123");
        User work = new User("worker","admin","work","123");
        users.add(admin);
        users.add(mem);
        users.add(work);

//        userModel.registerUser(users,sc);
//        userModel.registerUser(users,sc);
        System.out.println(users);
        userModel.login(users,sc);
    }
}
