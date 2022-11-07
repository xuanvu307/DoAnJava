package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class FeedBackModel {
    public void newFeedBack(List<Feedback> feedbacks, Scanner sc, String username){
        System.out.println("enter feedback: ");
        String feedBack = sc.nextLine();
        Feedback feedback = new Feedback();
        feedback.setTimeFeedback(LocalDateTime.now());
        feedback.setFeedback(feedBack);
        feedback.setUserName(username);

        feedbacks.add(feedback);
    }
}
