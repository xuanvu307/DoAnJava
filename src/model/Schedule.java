package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    private static int id;
    private int idSchedule;
    private String userName;
    private LocalDateTime time;
    private String status = "pending";


    public Schedule(String userName, LocalDateTime time) {
        this.userName = userName;
        this.time = time;
        this.idSchedule = id++;
    }

    public String getUserName() {
        return userName;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + idSchedule +
                ", userName='" + userName + '\'' +
                ", time: " + time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                ", status='" + status + '\'' +
                "\n";
    }
}
