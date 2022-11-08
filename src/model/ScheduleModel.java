package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScheduleModel {


    // nhập ngày từ bàn phím và yêu cầu nhập đúng định dạng
    public LocalDate inputDay(Scanner sc){
        do {
            try {
                System.out.println("enter day(dd/MM/yyyy): ");
                String day = sc.nextLine();
                return LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e){
                System.out.println("input date format dd/MM/yyyy");
            }
        } while (true);
    }

    // Nhập giờ từ bàn phím và yêu cầu nhập đúng định dạng
    public LocalTime inputTime(Scanner sc){
        while (true){
            try {
                System.out.println("enter time(HH:mm): ");
                String time = sc.nextLine();
                return LocalTime.parse(time,DateTimeFormatter.ofPattern("HH:mm"));
            }catch (Exception e){
                System.out.println("format time HH:mm");
            }
        }
    }

    // check thời gina ngày và giờ
    public String checkDateTime(LocalDate date, LocalTime time){
        if (LocalDate.now().compareTo(date) > 0){
            System.out.println("booking date has passed");
        } else {
            // kiểm tra có trong giờ làm việc không( giả sử giờ làm việc từ 8-20h)
            if (time.getHour()<= 8 || time.getHour() >= 20){
                System.out.println("outside working hours");
            } else {
                //kiểm tra thời gian đặt có ít hơn 15 phút không
                if (time.isAfter(LocalTime.now().plusMinutes(15))){
                    System.out.println("OK");
                    return "OK";
                } else {
                    System.out.println("booking time has passed");
                }
            }
        }
        return "";
    }


    /*
     * Đặt lịch
     * nhập ngày và giờ cần đặt lịch, người dùng sẽ được kiểm tra giờ đặt
     * nếu giờ đặt đã qua thì yêu cầu đặt lại
     * nếu đặt lịch thành công thì lịch sẽ được thêm vào list đặt lịch và ở trạng thái chờ phê huyệt
     */
    public void setSchedule(String username, ArrayList<Schedule> schedules, Scanner sc){
        LocalDate date = inputDay(sc);
        LocalTime time = inputTime(sc);
        String check = checkDateTime(date,time);
        if (check.equals("OK")){
            LocalDateTime dateTime = date.atTime(time);
            Schedule schedule = new Schedule(username,dateTime);
            schedules.add(schedule);
        } else {
            setSchedule(username, schedules, sc);
        }
    }


    //Sửa lịch
    public void editScheduleByUser(ArrayList<Schedule> schedules, String username, Scanner sc){
        for (Schedule schedule: schedules) {
            if (schedule.getUserName().equals(username)){
                System.out.println(schedule);
            }
        }
        System.out.println("Enter id schedule delete");
        int id = Integer.parseInt(sc.nextLine());
        for (Schedule schedule: schedules) {
            if (schedule.getIdSchedule() == id && schedule.getStatus().equals("pending")){
                setSchedule(username,schedules,sc);
            }
        }
    }

    // user xem lại toàn bộ lịch sử đặt lịch
    public void viewScheduleByUser(ArrayList<Schedule> schedules, String username){
        int check = 0;
        for (Schedule schedule: schedules) {
            if (schedule.getUserName().equals(username)){
                System.out.println(schedule);
                check++;
            }
        }
        if (check == 0){
            System.out.println("No Data");
        }
    }

    // User xóa đơn
    // chỉ xóa được đơn ở trạng thái chờ duyệt
    public void remoteScheduleByUser(ArrayList<Schedule> schedules,String username, Scanner sc){
        for (Schedule schedule: schedules) {
            if (schedule.getUserName().equals(username)){
                System.out.println(schedule);
            }
        }
        System.out.println("Enter id schedule delete");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getIdSchedule() == id && schedules.get(i).getStatus().equals("pending")){
                schedules.remove(i);
            }
        }
    }

    public void setStatusSchedule(ArrayList<Schedule> schedules, Scanner sc){
        System.out.println(schedules);
        System.out.println("input id set status");
        int id = Integer.parseInt(sc.nextLine());
        for (Schedule schedule: schedules){
            if (schedule.getIdSchedule() == id){
                System.out.println("1. confirm");
                System.out.println("2. decline");
                System.out.println("3. complete");
                int choose = Integer.parseInt(sc.nextLine());
                if (choose == 1){
                    schedule.setStatus("confirm");
                } else if (choose == 2){
                    schedule.setStatus("decline");
                } else {
                    schedule.setStatus("complete");
                }
            }
        }
    }

    public int checkPending(ArrayList<Schedule> schedules){
        int sum = 0;
        for (Schedule s: schedules
             ) {
            if (s.getStatus().equals("pending")){
                sum++;
            }
        }
        return sum;
    }

}
