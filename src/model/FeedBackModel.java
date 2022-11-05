package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeedBackModel {
    public void feedBack(List<Feedback> feedbacks, Scanner sc, String name){
        System.out.println("bla");
        String feedBack = sc.nextLine();
        Feedback feedback = new Feedback();
        feedback.setTimeFeedback(LocalDateTime.now());
        feedback.setFeedback(feedBack);
        feedback.setUserName(name);

        feedbacks.add(feedback);
    }
}
