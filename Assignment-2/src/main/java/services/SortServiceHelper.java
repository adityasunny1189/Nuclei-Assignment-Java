package services;

import java.util.List;
import models.UserClass;

/**
 * sorting service.
 */
public final class SortServiceHelper {
  private SortServiceHelper() {

  }

  /**
   * sort users.
   */
  public static void sort(int sortChoice, List<UserClass> users) {
    switch (sortChoice) {
      case 1:
        SortingChoicesServiceHelper.sortByName(users);
        break;
      case 2:
        SortingChoicesServiceHelper.sortByAge(users);
        break;
      case 3:
        SortingChoicesServiceHelper.sortByRoll(users);
        break;
      default:
        System.out.println("Invalid Choice");
    }
  }
}
