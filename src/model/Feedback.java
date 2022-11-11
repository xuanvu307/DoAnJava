package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Feedback{
    private LocalDateTime timeFeedback;
    private String feedback;
    private String userName;
    private int idSchedule;

    public LocalDateTime getTimeFeedback() {
        return timeFeedback;
    }

    public void setTimeFeedback(LocalDateTime timeFeedback) {
        this.timeFeedback = timeFeedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    @Override
    public String toString() {
        return "Feedback:" +
                "userName='" + userName + '\'' +
                ", idSchedule=" + idSchedule +
                ", feedback='" + feedback + '\'' +
                ", timeFeedback=" + timeFeedback.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                "\n";
    }
}
