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
        System.out.println("enter phoneNUmber: ");
        String phone = regex.checkPhoneNumber(sc);
        System.out.println("enter username:");
        String username = regex.checkUserName(sc);
        System.out.println("enter password");
        String password = regex.checkPassword(sc);

        if (!checkUserName(username,users)){
            System.out.println("register OK");
            User user = new User(name,username,password,phone);
            users.add(user);
        }
    }

    public void login(ArrayList<Feedback> feedbacks, ArrayList<User> users, ArrayList<Schedule> schedules, Scanner sc){
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("password: ");
        String password = sc.nextLine();
        int check =0;
        for (User user: users)
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                System.out.println("Login successfully!");
                check =1;
                View view = new View();
                if (user.getRole().equals("admin")){
                    view.adminView(sc);
                } else if (user.getRole().equals("worker")){
                    view.workerView();
                } else {
                    view.memberView(user.getUsername(),sc,feedbacks,users, schedules);
                }
            }
        if (check == 0){
            System.out.println("login fail");
            View view = new View();
            view.loginFail(feedbacks,users, schedules,sc);
        }
    }

    // đặt lại mật khẩu bằng sdt
    // mật khẩu đặt lại theo đúng định dạng regex
    public void forgetPassword(ArrayList<User> users,Scanner sc){
        int check = 0;
        System.out.println("input phoneNUmber ");
        String phone = sc.nextLine();
        for (User user:users) {
            if (user.getPhoneNumber().equals(phone)){
                System.out.println("Please input new pass:");
                String newPassword = regex.checkPassword(sc);
                user.setPassword(newPassword);
                System.out.println(" set new password success : " + user.getPassword());
                check =1;
            }
        }
        if (check ==0){
            System.out.println("phone number wrong");
        }
    }

    // đổi password
    public void changePassword(ArrayList<User> users,Scanner sc, String username){
        for (User user: users) {
            if (user.getUsername().equals(username)){
                System.out.println("new password");
                String newPassword = regex.checkPassword(sc);
                user.setPassword(newPassword);
                System.out.println("set new password success");
            }
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
