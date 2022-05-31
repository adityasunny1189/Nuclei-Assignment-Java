package services;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.DisplayHelper;
import models.UserClass;
import utility.UtilityClassHelper;

/**
 * service class.
 */
public final class ServicesHelper {
  private ServicesHelper() {

  }

  /**
   * load user function.
   * @param filePath represents file path
   *
   */
  public static List<UserClass> loadUsers(String filePath) {
    List<UserClass> userClasses = new ArrayList<>();
    try {
      final FileReader reader = new FileReader(filePath);
      int index;
      final StringBuilder jsonString = new StringBuilder();
      index = reader.read();
      while (index != -1) {
        jsonString.append((char) index);
        index = reader.read();
      }
      userClasses = UtilityClassHelper.decode(jsonString.toString());
      reader.close();
    } catch (IOException exception) {
      System.out.println("error" + exception);
    }
    return userClasses;
  }

  /**
   * load roll number.
   * @param userClasses represents users
   *
   */
  public static List<Integer> loadRollNum(List<UserClass> userClasses) {
    final List<Integer> rolls = new ArrayList<>();
    for (final UserClass userClass : userClasses) {
      rolls.add(userClass.getRoll());
    }
    return rolls;
  }

  /**
   * save user details to memory.
   * @param userClasses represents users
   * @param filePath represents file path
   */
  public static void saveDetails(List<UserClass> userClasses, String filePath) {
    final String json = UtilityClassHelper.encode(userClasses);
    try {
      final FileWriter file = new FileWriter(filePath);
      file.write(json);
      file.flush();
    } catch (IOException exception) {
      System.out.println("error" + exception);
    }
  }

  /**
   * delete user.
   * @param userClasses represents users
   * @param roll represents roll
   */
  public static void deleteUser(List<UserClass> userClasses, int roll) {
    userClasses.removeIf(userClass -> userClass.getRoll() == roll);
  }

  /**
   * display all user.
   * @param users represents users
   */
  public static void displayUsers(List<UserClass> users, Scanner sc) {
    int sortChoice;
    System.out.print(DisplayHelper.DISPLAY_USER_BY);
    sortChoice = sc.nextInt();
    SortServiceHelper.sort(sortChoice, users);
    System.out.print(DisplayHelper.USER_DETAIL_HEADER);
    for (final UserClass userClass : users) {
      System.out.printf(DisplayHelper.USER_DETAILS,
          userClass.getName(), userClass.getRoll(),
          userClass.getAge(), userClass.getAddress(),
          Arrays.toString(userClass.getCourses()));
    }
  }

  /**
   * add new user.
   * @param userClasses represents users
   * @param rolls represents rolls
   * @param sc represents scanner
   */
  public static void addUser(List<UserClass> userClasses, List<Integer> rolls, Scanner sc) {
    String name;
    name = UserServiceHelper.getUserName(sc);

    String address;
    address = UserServiceHelper.getUserAddress(sc);

    int age;
    age = UserServiceHelper.getUserAge(sc);

    int roll;
    roll = UserServiceHelper.getUserRoll(rolls, sc);

    char[] courses;
    courses = UserServiceHelper.getUserCourses(sc);

    final UserClass userClass = new UserClass();
    userClass.setName(name);
    userClass.setAddress(address);
    userClass.setAge(age);
    userClass.setRoll(roll);
    userClass.setCourses(courses);

    userClasses.add(userClass);
    rolls.add(userClass.getRoll());
  }

  /**
   * get roll for deletion.
   */
  public static int getRollForDeletion(Scanner sc, List<Integer> rolls) {
    int roll;
    while (true) {
      try {
        System.out.print("Enter Roll: ");
        roll = sc.nextInt();
        if (ValidationServiceHelper.validateRollForDeletion(rolls, roll)) {
          return roll;
        } else {
          System.out.println(DisplayHelper.INVALID_ROLL_NUMBER);
        }
      } catch (InputMismatchException exception) {
        System.out.println("Input type mismatch");
        sc.nextLine();
      }
    }
  }
}
