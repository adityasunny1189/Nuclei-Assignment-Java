package application;

import java.util.List;
import java.util.Scanner;

import models.Display;
import models.UserClass;
import services.ServicesHelper;
import services.SortServiceHelper;

/**
 * App class.
 */
public final class AppClass {
  private AppClass() {

  }

  /**
   * start function.
   * @param args represents args
   */
  public static void startApp() {
    final String filePath = "users.json";

    final List<UserClass> users = ServicesHelper.loadUsers(filePath);

    final List<Integer> rolls = ServicesHelper.loadRollNum(users);

    final Display content = new Display();

    boolean flag = true;
    final Scanner sc = new Scanner(System.in);
    while (flag) {
      int choice;
      System.out.print(content.getDisplayDetails());
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          sc.nextLine();
          ServicesHelper.addUser(users, rolls, sc);
          break;
        case 2:
          ServicesHelper.displayUsers(users, content, sc);
          break;
        case 3:
          int roll;
          roll = ServicesHelper.getRollForDeletion(sc, rolls, content);
          ServicesHelper.deleteUser(users, roll);
          break;
        case 4:
          ServicesHelper.saveDetails(users, filePath);
          break;
        case 5:
          sc.close();
          flag = false;
          break;
        default:
          System.out.println(content.getInvalidChoice());
      }
    }
  }
}
