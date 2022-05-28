import models.Display;
import models.User;
import services.Services;

import java.util.List;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        String filePath = "users.json";

        // load users from the file
        List<User> users = Services.LoadUsers(filePath);

        // get all occupied roll numbers
        List<Integer> rolls = Services.LoadRollNum(users);

        // all the static content
        Display content = new Display();

        while (true) {
            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.print(content.getDisplayDetails());
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    Services.AddUser(users, rolls, sc);
                    break;
                case 2:
                    Services.DisplayUsers(users);
                    break;
                case 3:
                    int roll;
                    roll = sc.nextInt();
                    Services.DeleteUser(users, roll);
                    break;
                case 4:
                    Services.SaveDetails(users, filePath);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println(content.getInvalidChoice());
            }
        }
    }
}
