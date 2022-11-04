package view;

import model.User;
import model.UserModel;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    UserModel userModel = new UserModel();
    public  void homeView(ArrayList<User> users, Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("Choose number, please: ");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    userModel.login(users,sc);
                    break;
                case 2:
                    userModel.registerUser(users,sc);
                    break;
            }
        } catch (Exception e){
            System.out.println("enter number");
        }
    }

    public void loginFail(ArrayList<User> users, Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    userModel.login(users, sc);
                    break;
                case 2:
                    userModel.forgetPassword(users,sc);
                    break;
            }
        } catch (Exception e){
            System.out.println("enter number");
        }
    }


    public void adminView(Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. cho");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } catch (Exception e){
            System.out.println("enter number");
        }

    }
    public void memberView(){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
    }
    public void workerView(){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        System.out.println("3");
        System.out.println("3");
        System.out.println("3");
        System.out.println("3");
    }
}
