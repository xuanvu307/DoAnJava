package control;

import model.User;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        Scanner sc = new Scanner(System.in);
        View view = new View();
        ArrayList<User> users = new ArrayList<>();
        User admin = new User("admin","admin","admin","123","123");
        User mem = new User("member","admin","mem","123","555");
        User work = new User("worker","admin","worker","123", "23");
        users.add(admin);
        users.add(mem);
        users.add(work);
        view.homeView(users,sc);
        System.out.println(users);

=======
        long l = System.currentTimeMillis();
        System.out.println(l);
        System.out.println(l);
>>>>>>> Stashed changes
    }
}
