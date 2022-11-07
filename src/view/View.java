package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    UserModel userModel = new UserModel();
    ScheduleModel scheduleModel = new ScheduleModel();

    public  void homeView(ArrayList<Feedback> feedbacks, ArrayList<User> users, ArrayList<Schedule> schedules, Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.println("Choose number, please: ");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    userModel.login(feedbacks, users, schedules, sc);
                    break;
                case 2:
                    userModel.registerUser(users, sc);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
            }
        } catch (Exception e){
            System.out.println("enter number");
        }
    }

    public void loginFail(ArrayList<Feedback> feedbacks,ArrayList<User> users, ArrayList<Schedule> schedules, Scanner sc){
        System.out.println("---------- MENU ----------");
        System.out.println("1. Login");
        System.out.println("2. Forgot password");
        System.out.println("Choose number, please: ");
        try{
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1 -> userModel.login(feedbacks, users, schedules,sc);
                case 2 -> userModel.forgetPassword(users, sc);
            }
        } catch (Exception e){
            System.out.println("enter number");
        }
    }


    public void adminView(Scanner sc){
        System.out.println("---------- ADMIN ----------");
        System.out.println("1. Accept schedule");
        System.out.println("2. View list schedule");
        System.out.println("3. View list feedback");
        System.out.println("4. Update Member");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
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
    public void memberView(String username, Scanner sc, ArrayList<Feedback> feedbacks, ArrayList<User> users, ArrayList<Schedule> schedules){
        boolean flag = true;
        do {
            System.out.println("HELLO "+username+" ----------");
            System.out.println("1. Set schedule");
            System.out.println("2. Update schedule");
            System.out.println("3. Remote schedule ");
            System.out.println("4. View schedule");
            System.out.println("5. Feedback");
            System.out.println("6. Change Password");
            System.out.println("0. Log out");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    scheduleModel.setSchedule(username,schedules,sc);
                    break;
                case 2:
                    scheduleModel.editScheduleByUser(schedules,username,sc);
                    break;
                case 3:
                    scheduleModel.remoteScheduleByUser(schedules,username,sc);
                    break;
                case 4:
                    scheduleModel.viewScheduleByUser(schedules,username);
                    break;
                case 5:
                    FeedBackModel feedBackModel = new FeedBackModel();
                    feedBackModel.newFeedBack(feedbacks,sc, username);
                    break;
                case 6:
                    userModel.changePassword(users,sc,username);
                    break;
                case 0:
                    flag = false;
                    homeView(feedbacks,users, schedules,sc);
            }
        } while (flag);
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
