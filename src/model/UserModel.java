package model;

import utils.Regex;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class UserModel {
    Regex regex = new Regex();


    // Đăng ký thành viên theo đúng định dạng regex
    //thành viên đăng ký thành công sẽ được thêm vào list users
    public void registerUser(ArrayList<User> users,Scanner sc){
        System.out.println("enter name: ");
        String name = sc.nextLine();
        System.out.println("enter username:");
        String username = regex.checkUserName(sc);
        System.out.println("enter password");
        String password = regex.checkPassword(sc);

        if (!checkUserName(username,users)){
            System.out.println("register OK");
            User user = new User(name,username,password);
            users.add(user);
        }
    }

    public void login(ArrayList<User> users,Scanner sc){
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("password: ");
        String password = sc.nextLine();
        int flag = 0;
        for (User user: users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                System.out.println("Login successfully!");
                flag = 1;
                View view = new View();
                if (user.getRole().equals("admin")){
                    view.adminView();
                } else if (user.getRole().equals("worker")){
                    view.workerView();
                } else {
                    view.memberView();
                }
            }
        }
        if (flag == 0){
            System.out.println("login fail");
        }
    }

    // duyệt hết các phần tử trong mảng xem đã username được sử dụng chưa
    public boolean checkUserName(String username, ArrayList<User> users){
        for (User user: users) {
            if (user.getUsername().equalsIgnoreCase(username)){
                System.out.println("username is already use");
                return true;
            }
        }
        return false;
    }
}
