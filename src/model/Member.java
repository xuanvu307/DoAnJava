package model;


public class Member extends User {
    private String ranking = "NoRank";
    private double score=0;

    public Member(String name, String username, String password, String phoneNumber) {
        super(name, username, password, phoneNumber);
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "ranking='" + ranking + '\'' +
                "\n ";
    }
}
