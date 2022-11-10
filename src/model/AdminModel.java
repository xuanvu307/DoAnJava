package model;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminModel {

    // set luồng cho các user
    // 1 tài khoản có thể là member, worker hoặc là admin
    // cần nhập ID chính xác hoặc username, sau khi tìm hết list sẽ in ra cho người dùng 1 list user
    // chọn đúng ID để sét luồng
    public void setMemberByAdmin(ArrayList<User> users, Scanner sc){
        System.out.println("enter id or username: ");
        String idOrName = sc.nextLine();
        int checkId = 0;
        for (User user: users) {
            if (user.getIdUser().equals(idOrName) || user.getUsername().contains(idOrName)){
                System.out.println(user);
                System.out.println("choose ID");
                idOrName = sc.nextLine();
                if (user.getIdUser().equals(idOrName)){
                    checkId = 1;
                    System.out.println("choose number: \n1. set up admin \n2. set up worker \n3. set down member");
                    try {
                        int choose = Integer.parseInt(sc.nextLine());
                        if (choose == 1){
                            user.setRole("admin");
                            System.out.println("Set OK");
                        } else if(choose == 2) {
                            user.setRole("worker");
                            System.out.println("Set OK");
                        }else if (choose == 3){
                            user.setRole("member");
                            System.out.println("Set OK");
                        } else {
                            System.out.println("choose number wrong");
                        }
                    } catch (Exception e){
                        System.out.println("Enter number");
                    }
                }
            }
        }
        if (checkId == 0){
            System.out.println("ID or Username Wrong");
        }
    }
}
