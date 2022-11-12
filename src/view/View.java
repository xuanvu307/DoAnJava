package view;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    UserModel userModel = new UserModel();
    ScheduleModel scheduleModel = new ScheduleModel();
    MemberModel memberModel = new MemberModel();


    // trang đăng nhập đăng ký
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


    // đăng nhập lỗi
    // đăng nhập lại hoặc lấy lại mật khẩu
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


    /*
     * hiển thị của admin và các chức năng của admin
     * 1. duyệt đơn và sét trạng thái cho đơn
     * 2. xóa đơn
     * 3. phân quyền cho user
     * 4. xem toàn bộ danh sách lịch
     * 5. xem danh sách feedback
     * 6. xem danh sách user
     * 7. xem xếp hạng thành viên
     * 8. đổi password
     * 0. thoát về màn hình đăng nhập
     */ 

    public void adminView(ArrayList<User> users, ArrayList<Feedback> feedbacks, ArrayList<Schedule> schedules,Scanner sc){
        boolean flag = true;
        while (flag){
            System.out.println("---------- ADMIN ----------");
            System.out.println("1. Set status schedule");
            System.out.println("2. Remove schedule");
            System.out.println("3. Update Member");
            System.out.println("4. View list schedule");
            System.out.println("5. View list feedback");
            System.out.println("6. View list user");
            System.out.println("7. View Top");
            System.out.println("8. Change Password");
            System.out.println("0. Log Out");
            try {
                int choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        scheduleModel.setStatusSchedule(users, schedules, feedbacks, sc);
                        break;
                    case 2:
                        scheduleModel.remoteScheduleByAdmin(schedules,sc);
                        break;
                    case 3:
                        AdminModel adminModel = new AdminModel();
                        adminModel.setMemberByAdmin(users, sc);
                        break;
                    case 4:
                        System.out.println("total schedules: " + schedules.size());
                        System.out.println(schedules);
                        break;
                    case 5:
                        System.out.println(feedbacks);
                        break;
                    case 6:
                        System.out.println(users);
                        break;
                    case 7:
                        memberModel.top(users, "admin");
                        break;
                    case 8:
                        userModel.changePasswordByAdmin(users,sc);
                        break;
                    case 0:
                        flag = false;
                        break;
                }
            } catch (Exception e){
                System.out.println("Input number");
            }
        }
    }

    /*
     * hiển thị và các tính năng của member
     * 1. tạo đơn đặt hàng mới
     * 2. update đơn đặt hàng
     * 3. xóa đơn đặt hàng
     * 4. xem toàn bộ đơn đặt hàng
     * 5. feedback
     * 6. xem bảng xếp hạng và xếp hạng bản thân
     * 7. đổi mật khẩu
     * 0. thoát về màn hình đăng nhập
     */
    public void memberView(String username, Scanner sc, ArrayList<Feedback> feedbacks, ArrayList<User> users, ArrayList<Schedule> schedules){
        boolean flag = true;
        do {
            System.out.println("HELLO "+username+" ----------");
            System.out.println("1. Set schedule");
            System.out.println("2. Update schedule");
            System.out.println("3. Remove schedule ");
            System.out.println("4. View schedule");
            System.out.println("5. Feedback");
            System.out.println("6. View Top");
            System.out.println("7. Change Password");
            System.out.println("0. Log out");
            try {
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
                        feedBackModel.newFeedBack(users,schedules,feedbacks,sc, username);
                        break;
                    case 6:
                        memberModel.top(users,username);
                        break;
                    case 7:
                        userModel.changePassword(users,sc,username);
                        break;                
                    case 0:
                        flag = false;
                        break;
                }
            } catch (Exception e){
                System.out.println("input number");
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
            System.out.println("3. Remove schedule ");
            System.out.println("4. View schedule");
            System.out.println("5. Feedback");
            System.out.println("6. View Top");
            System.out.println("7. Change Password");
            System.out.println("8. Set Status Schedule");
            System.out.println("0. Log out");
            try {
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
                        feedBackModel.newFeedBack(users,schedules,feedbacks,sc, username);
                        break;
                    case 6:
                        memberModel.top(users,username);
                        break;
                    case 7:
                        userModel.changePassword(users,sc,username);
                        break;
                    case 8:
                        scheduleModel.setStatusSchedule(users, schedules, feedbacks, sc);
                        break;
                    case 0:
                        flag = false;
                        break;
                }
            } catch (Exception e){
                System.out.println("input number");
            }
        } while (flag);
    }
}
