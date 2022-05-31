package application;

import java.util.List;
import java.util.Scanner;

import models.DisplayHelper;
import models.UserClass;
import services.ServicesHelper;

/**
 * App class.
 */
public final class AppClassHelper {
  private AppClassHelper() {

  }

  /**
   * start function.
   */
  public static void startApp() {
    final String filePath = "users.json";

    final List<UserClass> users = ServicesHelper.loadUsers(filePath);

    final List<Integer> rolls = ServicesHelper.loadRollNum(users);

    boolean flag = true;
    final Scanner sc = new Scanner(System.in);
    while (flag) {
      int choice;
      System.out.print(DisplayHelper.DISPLAY_DETAILS);
      choice = sc.nextInt();

      switch (choice) {
        case 1:
          sc.nextLine();
          ServicesHelper.addUser(users, rolls, sc);
          break;
        case 2:
          ServicesHelper.displayUsers(users, sc);
          break;
        case 3:
          int roll;
          roll = ServicesHelper.getRollForDeletion(sc, rolls);
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
          System.out.println(DisplayHelper.INVALID_CHOICE);
      }
    }
  }
}
