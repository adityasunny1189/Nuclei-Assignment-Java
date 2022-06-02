package services;

import java.util.Comparator;
import java.util.List;

import models.User;

/**
 * sorting service class.
 */
public class SortingChoicesServiceHelper {
  private SortingChoicesServiceHelper() {

  }

  /**
   * sort by name.
   * @param users represents users
   */
  public static void sortByName(List<User> users) {
    final Comparator<User> byName = Comparator.comparing(User::getName);
    users.sort(byName);
  }

  /**
   * sort by name.
   * @param users represents users
   */
  public static void sortByAge(List<User> users) {
    final Comparator<User> byAge = Comparator.comparing(User::getAge);
    users.sort(byAge);
  }

  /**
   * sort by roll.
   * @param users represents users
   */
  public static void sortByRoll(List<User> users) {
    final Comparator<User> byRoll = Comparator.comparing(User::getRoll);
    users.sort(byRoll);
  }
}
