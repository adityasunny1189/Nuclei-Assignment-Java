package application;

import java.util.List;
import java.util.Scanner;

import models.Display;
import models.UserClass;
import services.ServicesHelper;
import services.SortServiceHelper;

/**
 * Main class.
 */
public final class MainClass {
  private MainClass() {

  }

  /**
   * Main function.
   * @param args represents args
   */
  public static void main(String[] args) {
    final String filePath = "users.json";

    // load users from the file
    final List<UserClass> users = ServicesHelper.loadUsers(filePath);

    // get all occupied roll numbers
    final List<Integer> rolls = ServicesHelper.loadRollNum(users);

    // all the static content
    final Display content = new Display();

    boolean flag = true;
    final Scanner sc = new Scanner(System.in);
    while (flag) {
      int choice;
      System.out.print(content.getDisplayDetails());
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          // Add User
          sc.nextLine();
          ServicesHelper.addUser(users, rolls, sc);
          break;
        case 2:
          // Display User
          int sortChoice;
          System.out.print(content.getDisplayUserBy());
          sortChoice = sc.nextInt();
          SortServiceHelper.sort(sortChoice, users);
          ServicesHelper.displayUsers(users, content);
          break;
        case 3:
          // Delete User
          int roll;
          roll = ServicesHelper.getRollForDeletion(sc, rolls, content);
          ServicesHelper.deleteUser(users, roll);
          break;
        case 4:
          // Save Details
          ServicesHelper.saveDetails(users, filePath);
          break;
        case 5:
          // Exit
          sc.close();
          flag = false;
          break;
        default:
          System.out.println(content.getInvalidChoice());
      }
    }
  }
}
