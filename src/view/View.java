package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    UserModel userModel = new UserModel();
    public  void homeView(ArrayList<Feedback> feedbacks, ArrayList<User> users, Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("Choose number, please: ");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    userModel.login(feedbacks,users,sc);
                    break;
                case 2:
                    userModel.registerUser(users,sc);
                    break;
            }
        } catch (Exception e){
            System.out.println("enter number");
        }
    }

    public void loginFail(ArrayList<Feedback> feedbacks,ArrayList<User> users, Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    userModel.login(feedbacks,users, sc);
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
        System.out.println("---------- ADMIN ----------");
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
    public void memberView(String name, Scanner sc, ArrayList<Feedback> feedbacks){
        System.out.println("HELLO "+name+" ----------");
        System.out.println("1. Login");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        System.out.println("2");
        MemberModel memberModel = new MemberModel();
        int choose = Integer.parseInt(sc.nextLine());
        try{
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
                    FeedBackModel feedBackModel = new FeedBackModel();
                    feedBackModel.feedBack(feedbacks,sc, name);
                    break;
            }
        } catch (Exception e){
            System.out.println("enter number");
        }
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
