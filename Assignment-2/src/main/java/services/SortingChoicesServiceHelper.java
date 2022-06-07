package services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
  public static List<User> sortByName(List<User> users) {
    final Comparator<User> byName = Comparator.comparing(User::getName);
    return users.stream().sorted(byName).collect(Collectors.toList());
  }

  /**
   * sort by name.
   * @param users represents users
   */
  public static List<User> sortByAge(List<User> users) {
    final Comparator<User> byAge = Comparator.comparing(User::getAge);
    return users.stream().sorted(byAge).collect(Collectors.toList());
  }

  /**
   * sort by roll.
   * @param users represents users
   */
  public static List<User> sortByRoll(List<User> users) {
    final Comparator<User> byRoll = Comparator.comparing(User::getRoll);
    return users.stream().sorted(byRoll).collect(Collectors.toList());
  }
}
