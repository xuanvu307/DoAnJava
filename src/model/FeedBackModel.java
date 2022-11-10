package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FeedBackModel {
    MemberModel memberModel = new MemberModel();

    //người dùng sẽ feedback vào 1 list
    // sau feedback sẽ được tính điểm để tăng hạng. tối đa 5 lần
    public void newFeedBack(ArrayList<User> users, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks, Scanner sc, String username){
        System.out.println("enter feedback: ");
        String feedBack = sc.nextLine();
        Feedback feedback = new Feedback();
        feedback.setTimeFeedback(LocalDateTime.now());
        feedback.setFeedback(feedBack);
        feedback.setUserName(username);
        memberModel.autoUpRank(users,schedules,feedbacks);
        feedbacks.add(feedback);
    }
}
