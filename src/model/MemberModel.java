package model;

import java.util.ArrayList;
import java.util.List;

public class MemberModel {

    // tự động tăng hạng cho thành viên dựa trên điểm số
    public void autoUpRank(ArrayList<User> users, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks){
        for (User user: users) {
            if (user.getRole().equals("member")){
                double score = score(user.getUsername(),schedules,feedbacks);
                Member member = (Member) user;
                member.setScore(score);
                member.setRanking(ranking(score));
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
            if (schedule.getUsername().equals(username) && schedule.getStatus().equals("complete")){
               score++;
            }
        }
        int check = 1;
        for (Feedback feedback: feedbacks){
            if (feedback.getUserName().equals(username) && check <= 5){
                score += 0.5;
                check++;
            }
        }
        return score;
    }


    // hạng thành viên đạt được

    public String ranking(double score){
        if ( score <= 2.0 && score > 1){
            return "Bronze";
        } else if (score <= 6.0 && score >2) {
            return "Silver";
        } else if (score <= 15.0 && score >6){
            return "Gold";
        } else if (score > 15){
            return "Platinum";
        } else {
            return "NoRank";
        }
    }

    // xem 3 người xếp hạng cao nhất và thứ hạng của bản thân
    public void top(ArrayList<User> users, String username){
        List<Member> members = new ArrayList<>();
        if (!users.isEmpty()){
            for (User u : users){
                if(u.getRole().equals("member")) members.add((Member) u);
            }
           members.sort((o1, o2) -> o1.getScore() < o2.getScore() ? 1 : -1);
            for (int i = 0; i < 3; i++) {
                System.out.println("TOP "+ (i+1)+" "+ members.get(i).getUsername()+ "\trank = "  + members.get(i).getRanking());
            }
            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).getUsername().equals(username)){
                    System.out.println("your rank: " +(i+1));
                }
            }
        }
    }
}
