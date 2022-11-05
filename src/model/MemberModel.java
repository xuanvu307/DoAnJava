package model;

import java.time.*;
import java.util.*;
import utils.Regex;

public class MemberModel {
    Regex regex = new Regex();

    public void setSchedule(LocalDateTime time, Scanner sc, List<Member> members) {
        System.out.println("Input your phone number: ");
        String phoneNumber = regex.checkPhoneNumber(sc);
        for (int i = 0; i < members.size(); i++) 
            if(phoneNumber.equals(members.get(i).getPhoneNumber())){
                members.get(i).setTime(time);
                System.out.println("Update schedule successfully!");
            }
        System.out.println("Phone number invalid!");
    }

    public void removeSchedule(Scanner sc, List<Member> members){
        System.out.println("Input your phone number: ");
        String phoneNumber = regex.checkPhoneNumber(sc);
        for (int i = 0; i < members.size(); i++) 
            if(phoneNumber.equals(members.get(i).getPhoneNumber())){
                members.remove(i);
                System.out.println("Remove schedule successfully!");
            }
        System.out.println("Phone number invalid!");
    }

    public void feedback(Scanner sc, List<Member> members, List<String> feedbacks){
        System.out.println("Input your phone number: ");
        String phoneNumber = regex.checkPhoneNumber(sc);
        for (int i = 0; i < members.size(); i++) 
            if(phoneNumber.equals(members.get(i).getPhoneNumber())){
                members.get(i).setFeedbacks(feedbacks);
                System.out.println("Thank you for your review!");
            }
        System.out.println("Phone number invalid!");
    }
}
