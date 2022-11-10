package model;


import java.util.ArrayList;

public class MemberModel {
    public void abc(ArrayList<User> users, ArrayList<Schedule> schedules){
        for (User user: users) {
            ScheduleModel scheduleModel = new ScheduleModel();
            int total = scheduleModel.totalComplete(schedules);
            if (total == 1){
                Member member = new Member(user);
//                member.setRanking("Bronze");
                users.add(member);
            }
        }
    }


}
