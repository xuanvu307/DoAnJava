package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    UserModel userModel = new UserModel();
    ScheduleModel scheduleModel = new ScheduleModel();

    public  void homeView(ArrayList<Feedback> feedbacks, ArrayList<User> users, ArrayList<Schedule> schedules, Scanner sc){
        boolean flag =true;
        while (flag){
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
                        homeView(feedbacks,users,schedules,sc);
                        break;
                    case 0:
                        System.out.println("Exit");
                        flag = false;
                        break;
                }
            } catch (Exception e){
                System.out.println("enter number");
            }
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


    public void adminView(ArrayList<User> users, ArrayList<Feedback> feedbacks, ArrayList<Schedule> schedules,Scanner sc){
        boolean flag = true;
        while (flag){
            System.out.println("---------- ADMIN ----------");
            System.out.println("1. Set status schedule");
            System.out.println("2. View list schedule");
            System.out.println("3. View list feedback");
            System.out.println("4. View list user");
            System.out.println("5. Update Member");
            System.out.println("6. Remote schedule");
            System.out.println("6. ");
            System.out.println("0. Log Out");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    ScheduleModel scheduleModel = new ScheduleModel();
                    System.out.println("Unprocessed orders: " +scheduleModel.checkPending(schedules));
                    scheduleModel.setStatusSchedule(users, schedules,sc);
                    break;
                case 2:
                    System.out.println("total schedules: "+schedules.size());
                    System.out.println(schedules);
                    break;
                case 3:
                    System.out.println(feedbacks);
                    break;
                case 4:
                    System.out.println(users);
                    break;
                case 5:
                    AdminModel adminModel = new AdminModel();
                    adminModel.setMember(users,sc);
                    break;
                case 6:
                    break;
                case 0:
                    flag = false;
                    homeView(feedbacks,users, schedules,sc);
            }
        }
    }

    // các tính năng mà member sử dụng được
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
                    scheduleModel.editScheduleByMember(schedules,username,sc);
                    break;
                case 3:
                    scheduleModel.remoteScheduleByUser(schedules,username,sc);
                    break;
                case 4:
                    scheduleModel.viewScheduleByMember(schedules,username);
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

    // có đầy đủ tính năng của member
    // thêm tính năng sửa trạng thái của lịch
    public void workerView(String username, Scanner sc, ArrayList<Feedback> feedbacks, ArrayList<User> users, ArrayList<Schedule> schedules){
        boolean flag = true;
        do {
            System.out.println("HELLO "+username+" ----------");
            System.out.println("1. Set schedule");
            System.out.println("2. Update schedule");
            System.out.println("3. Remote schedule ");
            System.out.println("4. View schedule");
            System.out.println("5. Feedback");
            System.out.println("6. Change Password");
            System.out.println("7. Chang status schedule");
            System.out.println("0. Log out");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    scheduleModel.setSchedule(username,schedules,sc);
                    break;
                case 2:
                    scheduleModel.editScheduleByMember(schedules,username,sc);
                    break;
                case 3:
                    scheduleModel.remoteScheduleByUser(schedules,username,sc);
                    break;
                case 4:
                    scheduleModel.viewScheduleByMember(schedules,username);
                    break;
                case 5:
                    FeedBackModel feedBackModel = new FeedBackModel();
                    feedBackModel.newFeedBack(feedbacks,sc, username);
                    break;
                case 6:
                    userModel.changePassword(users,sc,username);
                    break;
                case 7:
                    ScheduleModel scheduleModel = new ScheduleModel();
                    System.out.println("Unprocessed orders: " +scheduleModel.checkPending(schedules));
                    scheduleModel.setStatusSchedule(users, schedules, sc);
                    break;
                case 0:
                    flag = false;
                    homeView(feedbacks,users, schedules,sc);
            }
        } while (flag);
    }
}
