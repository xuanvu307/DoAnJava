package model;

import java.time.LocalDateTime;
import java.util.*;

public class Member extends User {
    private List<String> feedbacks = new ArrayList();
    private String[] images = new String[3];
    private LocalDateTime time;

    public Member(LocalDateTime time) {
        this.time = time;
    }
    public Member(String role, String name, String username, String password, String phoneNumber, LocalDateTime time) {
        super(role, name, username, password, phoneNumber);
        this.time = time;
    }
    public List<String> getFeedbacks() {
        return feedbacks;
    }
    public void setFeedbacks(List<String> feedbacks) {
        this.feedbacks = feedbacks;
    }
    public String[] getImages() {
        return images;
    }
    public void setImages(String[] images) {
        this.images = images;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Member [feedbacks=" + feedbacks + ", images=" + Arrays.toString(images) + ", time=" + time + "]";
    }
    
    
}
