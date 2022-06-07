package services;

import java.util.List;

import models.DisplayConstants;
import models.User;

/**
 * sorting service.
 */
public class SortServiceHelper {
  private SortServiceHelper() {

  }

  /**
   * sort users.
   */
  public static List<User> sort(int sortChoice, List<User> users) {
    switch (sortChoice) {
      case 1:
        return SortingChoicesServiceHelper.sortByName(users);
      case 2:
        return SortingChoicesServiceHelper.sortByAge(users);
      case 3:
        return SortingChoicesServiceHelper.sortByRoll(users);
      default:
        System.out.println(DisplayConstants.INVALID_CHOICE);
        return users;
    }
  }
}
