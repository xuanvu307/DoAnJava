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
        System.out.println("enter day(dd/MM/yyyy): ");
        do {
            try {
                String day = sc.nextLine();
                return LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (Exception e){
                System.out.println("input date format dd/MM/yyyy");
            }
        } while (true);
    }

    // Nhập giờ từ bàn phím và yêu cầu nhập đúng định dạng
    public LocalTime inputTime(Scanner sc){
        System.out.println("enter time(HH:mm): ");
        while (true){
            try {
                String time = sc.nextLine();
                return LocalTime.parse(time,DateTimeFormatter.ofPattern("HH:mm"));
            }catch (Exception e){
                System.out.println("format time HH:mm");
            }
        }
    }

    // check thời gina ngày và giờ
    public String checkDateTime(LocalDate date, LocalTime time){
        // kiểm tra có trong giờ làm việc không( giả sử giờ làm việc từ 8-20h)
        if (time.getHour()< 8 || time.getHour() >= 20) {
            System.out.println("outside working hours");
        } else {
            // Kiểm tra ngày đặt với ngày hiện tại
            // nếu qua ngày thì bỏ qua
            // nếu chưa đến ngày thì ok luôn
            // nếu trong ngày thì xét với giờ hiện tại ( Đặt lịch phải trước ít nhất 15 phút)
            if (LocalDate.now().compareTo(date) > 0){
                System.out.println("booking date has passed");
            } else if (LocalDate.now().compareTo(date) < 0){
                return "OK";
            } else {
                if (time.isAfter(LocalTime.now().plusMinutes(15))){
                    return "OK";
                } else {
                    System.out.println("booking time has passed");
                }
            }
        }
        return "";
    }

    // kiểm tra có lịch nào đang chờ duyệt hay không
    public String checkSchedule(String username, ArrayList<Schedule> schedules){
        for (Schedule schedule: schedules){
            if (schedule.getUsername().equals(username) && schedule.getStatus().equals("pending")){
                System.out.println("duplication schedule");
                return "";
            }
        } return "OK";
    }

    /*
     * Đặt lịch
     * nhập ngày và giờ cần đặt lịch, người dùng sẽ được kiểm tra giờ đặt
     * nếu giờ đặt đã qua thì yêu cầu đặt lại
     * kiểm tra xem có trùng lịch hay không(Một người chỉ được đặt  1 lịch ở trạng thái chờ)
     * nếu đặt lịch thành công thì lịch sẽ được thêm vào list đặt lịch và ở trạng thái chờ phê huyệt
     */
    public void setSchedule(String username, ArrayList<Schedule> schedules, Scanner sc){
        LocalDate date = inputDay(sc);
        LocalTime time = inputTime(sc);
        // kiểm tra ngày giờ có hợp lệ không
        String check = checkDateTime(date,time);
        // kiểm tra có lịch nào chờ không
        String checkSchedule = checkSchedule(username, schedules);
        if (check.equals("OK") && checkSchedule.equals("OK")){
            LocalDateTime dateTime = date.atTime(time);
            Schedule schedule = new Schedule(username,dateTime);
            schedules.add(schedule);
            System.out.println("OK");
        }
    }


    //Sửa lịch
    // Mem có thể sửa lại lịch ở trạng thái chờ duyệt
    public void editScheduleByMember(ArrayList<Schedule> schedules, String username, Scanner sc){
       int check = totalPendingByMember(schedules,username);
       if (check != 0){
           boolean checkID = false;
           System.out.println("Enter id schedule edit");
           try {
               int id = Integer.parseInt(sc.nextLine());
               for (Schedule schedule: schedules) {
                   if (schedule.getIdSchedule() == id && schedule.getStatus().equals("pending") && schedule.getUsername().equals(username)){
                       checkID = true;
                       LocalDate date = inputDay(sc);
                       LocalTime time = inputTime(sc);
                       String checkDateTime = checkDateTime(date,time);
                       if (checkDateTime.equals("OK")){
                           schedule.setTime(date.atTime(time));
                       }
                       System.out.println("OK");
                   }
               }
               if (!checkID) System.out.println("Wrong ID");
           } catch (Exception e){
               System.out.println("enter number");
           }
       }
    }

    // member hiển thị đơn hàng ở trạng thái pending
    public int totalPendingByMember(ArrayList<Schedule> schedules, String username){
        int check = 0;
        for (Schedule schedule: schedules) {
            if (schedule.getUsername().equals(username) && schedule.getStatus().equals("pending")){
                System.out.println(schedule);
                check++;
            }
        }
        if (check == 0){
            System.out.println("No Data");
        }
        return check;
    }

    // user xem lại toàn bộ lịch sử đặt lịch của user
    public void viewScheduleByMember(ArrayList<Schedule> schedules, String username){
        int check = 0;
        for (Schedule schedule: schedules) {
            if (schedule.getUsername().equals(username)){
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
    // đơn bị xóa sẽ chuyển sang trạng thái hủy
    public void remoteScheduleByUser(ArrayList<Schedule> schedules,String username, Scanner sc){
        int check = totalPendingByMember(schedules,username);
        if (check != 0){
            boolean checkID = false;
            System.out.println("Enter id schedule delete");
            try {
                int id = Integer.parseInt(sc.nextLine());
                for (Schedule schedule : schedules) {
                    if (schedule.getIdSchedule() == id && schedule.getStatus().equals("pending") && schedule.getUsername().equals(username)) {
                        schedule.setStatus("decline");
                        System.out.println("OK");
                        checkID = true;
                    }
                }
                if (!checkID) System.out.println("Wrong ID");
            } catch (Exception e){
                System.out.println("enter number");
            }
        }
    }


    // hủy đơn bởi admin( chỉ hủy đơn ở trạng thái chờ duyệt hoặc chờ hoàn thiện)
    public void remoteScheduleByAdmin(ArrayList<Schedule> schedules, Scanner sc){
        int checkOrder = orderCheck(schedules);
        if (checkOrder != 0){
            System.out.println("Enter id schedule delete");
            try {
                int id = Integer.parseInt(sc.nextLine());
                int check = 0;
                for (Schedule schedule : schedules) {
                    if (schedule.getIdSchedule() == id && ((schedule.getStatus().equals("pending")) || schedule.getStatus().equals("confirm"))) {
                        schedule.setStatus("decline");
                        System.out.println("OK");
                        check ++;
                    }
                }
                if (check == 0) System.out.println("ID Wrong");
            } catch (Exception exception){
                System.out.println("enter number");
            }
        }
    }

    /*
    set trạng thái của đơn
    - đơn mới tạo ra mặc định là pending. người dùng có thế tương tác với đơn ở trạng thái này
    - đơn sẽ được admin confirm hoặc decline. sau khi duyệt chỉ admin có quyền tương tác
    - đơn đã hoàn thiện không thể sét
    - trạng thái 3 sau khi hoàn thiện đơn
     + khi sét hoàn thiện đơn sẽ tự động cộng lại điểm

     */

    public void setStatusSchedule(ArrayList<User> users, ArrayList<Schedule> schedules, ArrayList<Feedback> feedbacks, Scanner sc){
        int checkOrder = orderCheck(schedules);
        if (checkOrder != 0){
            System.out.println("input id set status");
            try {
                int id = Integer.parseInt(sc.nextLine());
                for (Schedule schedule: schedules){
                    if (schedule.getIdSchedule() == id && schedule.getStatus().equals("pending")) {
                        System.out.println("1. confirm");
                        System.out.println("2. decline");
                        int choose = Integer.parseInt(sc.nextLine());
                        if (choose == 1){
                            schedule.setStatus("confirm");
                        } else if (choose == 2) {
                            schedule.setStatus("decline");
                        } else {
                            System.out.println("number fail");
                        }
                    } else if (schedule.getIdSchedule() == id && schedule.getStatus().equals("confirm")){
                        System.out.println("1. complete");
                        System.out.println("2. decline");
                        int choose = Integer.parseInt(sc.nextLine());
                        if (choose == 1){
                            schedule.setStatus("complete");
                            MemberModel memberModel = new MemberModel();
                            memberModel.autoUpRank(users,schedules,feedbacks);
                        } else if (choose == 2) {
                            schedule.setStatus("decline");
                        } else {
                            System.out.println("number fail");
                        }
                    }
                }
            } catch (Exception e){
                System.out.println("enter number");
            }
        }
    }

    // Đếm số đơn cần xử lý
    public int orderCheck(ArrayList<Schedule> schedules){
        int sum = 0;
        for (Schedule schedule: schedules){
            if (schedule.getStatus().equals("pending")|| schedule.getStatus().equals("confirm")){
                System.out.println(schedule);
                sum++;
            }
        }
        if (sum ==0){
            System.out.println("no order status pending and confirm");
        } else {
            System.out.println("can process orders: " +sum);
        }
        return sum;
    }

}
