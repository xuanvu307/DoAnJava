package model;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminModel {
    public void setMember(ArrayList<User> users, Scanner sc){
        System.out.println("enter id : ");
        String id = sc.nextLine();
        int checkId = 0;
        for (User user: users) {
            if (user.getIdUser().equals(id)){
                checkId = 1;
                System.out.println("choose number: \n1. set up admin \n2. set up worker \n3. set down member");
                int choose = Integer.parseInt(sc.nextLine());
                if (choose == 1){
                    user.setRole("admin");
                } else if(choose == 2) {
                    user.setRole("worker");
                }else if (choose == 3){
                    user.setRole("member");
                } else {
                    System.out.println("choose number wrong");
                }
            }
        }
        if (checkId == 0){
            System.out.println("ID Wrong");
        }
    }

}
