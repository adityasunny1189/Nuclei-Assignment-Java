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
                    // Add User
                    sc.nextLine();
                    Services.AddUser(users, rolls, sc);
                    break;
                case 2:
                    // Display User
                    Services.DisplayUsers(users, content);
                    break;
                case 3:
                    // Delete User
                    int roll;
                    System.out.print(content.getInputRoll());
                    roll = sc.nextInt();
                    if (rolls.contains(roll)) {
                        Services.DeleteUser(users, roll);
                    } else {
                        System.out.println(content.getInvalidRoll());
                    }
                    break;
                case 4:
                    // Save Details
                    Services.SaveDetails(users, filePath);
                    break;
                case 5:
                    // Exit
                    System.exit(0);
                default:
                    System.out.println(content.getInvalidChoice());
            }
        }
    }
}
