package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FeedBackModel {
    MemberModel memberModel = new MemberModel();

    /*
    * mỗi lần cắt thành công người dùng sẽ được feedback 1 lần
    * lần feedback sẽ do người dùng chọn với lần đặt lịch đó
    * feedback thành công sẽ được thêm vào list
    * sau feedback sẽ được tính điểm để tăng hạng. tối đa 5 lần
     */
    public void newFeedBack(ArrayList<User> users, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks, Scanner sc, String username){
        int amountFeedback = amountFeedback(users,schedules,feedbacks,username);
        if (amountFeedback <= 0){
            System.out.println("can not feedback");
        } else {

            // in ra tất cả các lần thành công
            for (Schedule schedule: schedules) {
                if (schedule.getUsername().equals(username) && schedule.getStatus().equals("complete")) System.out.println(schedule);
            }
            // chọn id lần thành công và tiến hành feedback
            System.out.println("ID schedule");
            try{
                int id = Integer.parseInt(sc.nextLine());
                int checkID = 0;
                for (Schedule schedule: schedules) {
                    if (schedule.getIdSchedule() == id && schedule.getUsername().equals(username) && schedule.getStatus().equals("complete")){
                        System.out.println("enter feedback: ");
                        String feedBack = sc.nextLine();
                        Feedback feedback = new Feedback();
                        feedback.setTimeFeedback(LocalDateTime.now());
                        feedback.setFeedback(feedBack);
                        feedback.setUserName(username);
                        feedback.setIdSchedule(id);
                        feedbacks.add(feedback);
                        memberModel.autoUpRank(users,schedules,feedbacks);
                        checkID++;
                    }
                }
                if (checkID == 0) System.out.println("ID Wrong");
            } catch (Exception e){
                System.out.println("enter number");
            }

        }
    }


    // tính số lần được feedback
    //mỗi lần cắt thành công chỉ được feedback 1 lần
    public int amountFeedback(ArrayList<User> users, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks, String username){
        int totalFeedback = 0;
        int totalScheduleComplete = 0;
        for (User user: users){
            if (user.getUsername().equals(username)){
                for (Feedback feedback: feedbacks){
                    if (feedback.getUserName().equals(username)){
                        totalFeedback++;
                    }
                }
                for (Schedule schedule: schedules){
                    if (schedule.getUsername().equals(username) && schedule.getStatus().equals("complete")){
                        totalScheduleComplete++;
                    }
                }
            }
        }
        return totalScheduleComplete - totalFeedback;
    }
}
