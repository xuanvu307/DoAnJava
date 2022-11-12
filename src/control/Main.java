package control;

import model.*;
import view.View;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Feedback> feedbacks = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Schedule> schedules = new ArrayList<>();
        View view = new View();;
        User admin = new Admin("admin","admin","123","123");
        users.add(admin);

        view.homeView(feedbacks,users, schedules,sc);

    }
}
