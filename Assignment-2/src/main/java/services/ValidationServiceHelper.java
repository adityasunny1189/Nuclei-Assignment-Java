package services;

import java.util.List;

/**
 * validation service.
 */
public final class ValidationServiceHelper {
  private ValidationServiceHelper() {

  }

  /**
   * validate name.
   * @param name represents name
   *
   */
  public static boolean validateName(String name) {
    return name.length() > 5;
  }

  /**
   * validate age.
   * @param age represents age
   *
   */
  public static boolean validateAge(int age) {
    if (age <= 0) {
      return false;
    } else {
      return age <= 100;
    }
  }

  /**
   * validate address.
   * @param address represents address
   *
   */
  public static boolean validateAddress(String address) {
    return address.length() > 5;
  }

  /**
   * validate roll.
   * @param rolls represents rolls
   * @param roll represents roll
   *
   */
  public static boolean validateRoll(List<Integer> rolls, int roll) {
    if (roll <= 0) {
      return false;
    } else {
      return !rolls.contains(roll);
    }
  }

  /**
   * validate roll for deletion.
   * @param rolls represents rolls
   * @param roll represents roll
   *
   */
  public static boolean validateRollForDeletion(List<Integer> rolls, int roll) {
    if (roll <= 0) {
      return false;
    } else {
      return rolls.contains(roll);
    }
  }

  /**
   * validate course.
   * @param course represents courses
   *
   */
  public static boolean validateCourse(char course) {
    return course == 'A' || course == 'B'
        || course == 'C' || course == 'D'
        || course == 'E' || course == 'F';
  }
}
