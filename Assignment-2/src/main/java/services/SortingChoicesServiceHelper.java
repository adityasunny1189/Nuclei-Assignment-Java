package services;

import java.util.Comparator;
import java.util.List;
import models.UserClass;

/**
 * sorting service class.
 */
public final class SortingChoicesServiceHelper {
  private SortingChoicesServiceHelper() {

  }

  /**
   * sort by name.
   * @param users represents users
   */
  public static void sortByName(List<UserClass> users) {
    final Comparator<UserClass> byName = Comparator.comparing(UserClass::getName);
    users.sort(byName);
  }

  /**
   * sort by name.
   * @param users represents users
   */
  public static void sortByAge(List<UserClass> users) {
    final Comparator<UserClass> byAge = Comparator.comparing(UserClass::getAge);
    users.sort(byAge);
  }

  /**
   * sort by roll.
   * @param users represents users
   */
  public static void sortByRoll(List<UserClass> users) {
    final Comparator<UserClass> byRoll = Comparator.comparing(UserClass::getRoll);
    users.sort(byRoll);
  }
}
