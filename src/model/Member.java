package model;


public class Member extends User {
    private String ranking = "Bronze";

    public Member(User user) {
        super(user.getName(), user.getUsername(), user.getPassword(), user.getPhoneNumber());
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
