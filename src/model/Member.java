package model;


public class Member extends User {
    private String ranking = "NoRank";

    public Member(User user) {
        super(user.getName(), user.getUsername(), user.getPassword(), user.getPhoneNumber());
        this.ranking = ranking;
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
