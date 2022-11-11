package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    private static int id;
    private int idSchedule;
    private String username;
    private LocalDateTime time;
    private String status = "pending";


    public Schedule(String username, LocalDateTime time) {
        this.username = username;
        this.time = time;
        this.idSchedule = id++;
    }


    public int getIdSchedule() {
        return idSchedule;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Schedule:" +
                "idSchedule : " + idSchedule +
                ", userName='" + username + '\'' +
                ", time: " + time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                ", status='" + status + '\'' +
                "\n";
    }
}
