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
        View view = new View();

        User admin = new User("admin","admin","admin","123","123");
        User mem = new User("member","admin","mem","123","555");
        User mem1 = new User("member","admin","mem1","123","555");
        User work = new User("worker","admin","worker","123", "23");
        users.add(admin);
        users.add(mem);
        users.add(work);
        users.add(mem1);

        view.homeView(feedbacks,users,sc);
    }
}
