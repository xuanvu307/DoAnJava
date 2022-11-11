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
        User mem = new Member("admin","mem","123","123");
        User mem2 = new Member("admin","mem1","123","123");
        User mem3 = new Member("admin","mem2","123","123");
        User mem4 = new Member("admin","mem3","123","123");
        users.add(admin);
        users.add(mem);
        users.add(mem2);
        users.add(mem3);
        users.add(mem4);

        view.homeView(feedbacks,users, schedules,sc);

    }
}
