package model;


public class Member extends User {
    private String ranking = "NoRank";
    private double score=0;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Member(User user) {
        super(user.getName(), user.getUsername(), user.getPassword(), user.getPhoneNumber());
        this.ranking = ranking;
    }

    public Member(String role, String name, String username, String password, String phoneNumber) {
        super(role, name, username, password, phoneNumber);
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return super.toString()+
                "ranking='" + ranking + '\'' +
                "\n" ;
    }
}
