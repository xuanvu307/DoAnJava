package model;


import java.util.ArrayList;

public class MemberModel {


    public void autoUpRank(ArrayList<User> users, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks){
        for (User user: users) {
            for (Schedule schedule: schedules){
                if (user.getUsername().equals(schedule.getUserName()) && user.getRole().equals("member")){
                    double score = score(user.getUsername(),schedules,feedbacks);
                    Member member = (Member) user;
                    member.setScore(score);
                    member.setRanking(ranking(score));
                }
            }
        }
    }

    /*
    tính điểm cắt tóc
     + mỗi lần cắt tóc thành công sẽ được + 1d
     + mỗi lần feedback sẽ được + 0.5d tối đa 5 lần
     */
    public double score(String username, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks){
        double score = 0;
        for (Schedule schedule: schedules){
            if (schedule.getUserName().equals(username) && schedule.getStatus().equals("complete")){
               score++;
            }
        }
        int check = 0;
        for (Feedback feedback: feedbacks){
            if (feedback.getUserName().equals(username) && check < 6){
                score += 0.5;
                check++;
            }
        }
        return score;
    }

    public String ranking(double score){
        if ( score < 1.5){
            return "Bronze";
        } else if (score < 3.0) {
            return "Silver";
        } else if (score < 7.0){
            return "Gold";
        } else {
            return "Platinum";
        }
    }
}
