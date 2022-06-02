package services;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import models.DisplayConstants;
import models.User;
import utility.ParserUtility;

/**
 * service class.
 */
public class ServicesHelper {
  private ServicesHelper() {

  }

  /**
   * load user function.
   * @param filePath represents file path
   *
   */
  public static List<User> loadUsers(String filePath) {
    List<User> users = new ArrayList<>();
    try {
      final FileReader reader = new FileReader(filePath);
      int index;
      final StringBuilder jsonString = new StringBuilder();
      index = reader.read();
      while (index != -1) {
        jsonString.append((char) index);
        index = reader.read();
      }
      users = ParserUtility.decode(jsonString.toString());
      reader.close();
    } catch (IOException exception) {
      System.out.println("error" + exception);
    }
    return users;
  }

  /**
   * load roll number.
   * @param users represents users
   *
   */
  public static List<Integer> loadRollNum(List<User> users) {
    final List<Integer> rolls = new ArrayList<>();
    for (final User user : users) {
      rolls.add(user.getRoll());
    }
    return rolls;
  }

  /**
   * save user details to memory.
   * @param users represents users
   * @param filePath represents file path
   */
  public static void saveDetails(List<User> users, String filePath) {
    final String json = ParserUtility.encode(users);
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
   * @param users represents users
   * @param roll represents roll
   */
  public static void deleteUser(List<User> users, int roll) {
    users.removeIf(userClass -> userClass.getRoll() == roll);
  }

  /**
   * display all user.
   * @param users represents users
   */
  public static void displayUsers(List<User> users, Scanner sc) {
    int sortChoice;
    System.out.print(DisplayConstants.DISPLAY_USER_BY);
    sortChoice = sc.nextInt();
    SortServiceHelper.sort(sortChoice, users);
    System.out.print(DisplayConstants.USER_DETAIL_HEADER);
    for (final User user : users) {
      System.out.printf(DisplayConstants.USER_DETAILS,
          user.getName(), user.getRoll(),
          user.getAge(), user.getAddress(),
          Arrays.toString(user.getCourses()));
    }
  }

  /**
   * add new user.
   * @param users represents users
   * @param rolls represents rolls
   * @param sc represents scanner
   */
  public static void addUser(List<User> users, List<Integer> rolls, Scanner sc) {
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

    final User user = new User();
    user.setName(name);
    user.setAddress(address);
    user.setAge(age);
    user.setRoll(roll);
    user.setCourses(courses);

    users.add(user);
    rolls.add(user.getRoll());
  }

  /**
   * get roll for deletion.
   */
  public static int getRollForDeletion(Scanner sc, List<Integer> rolls) {
    int roll;
    while (true) {
      try {
        System.out.print(DisplayConstants.ENTER_ROLL_NO);
        roll = sc.nextInt();
        if (ValidationServiceHelper.validateRollForDeletion(rolls, roll)) {
          return roll;
        } else {
          System.out.println(DisplayConstants.INVALID_ROLL_NUMBER);
        }
      } catch (InputMismatchException exception) {
        System.out.println(DisplayConstants.INPUT_TYPE_MISMATCH);
        sc.nextLine();
      }
    }
  }
}
