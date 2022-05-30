package services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * user service.
 */
public final class UserServiceHelper {
  private UserServiceHelper() {

  }

  /**
   * get username.
   * @param sc represents scanner
   *
   */
  public static String getUserName(Scanner sc) {
    String name;
    while (true) {
      System.out.print("Enter Name: ");
      name = sc.nextLine();
      if (ValidationServiceHelper.validateName(name)) {
        return name;
      } else {
        System.out.println("Invalid Name");
      }
    }
  }

  /**
   * get user address.
   * @param sc represents scanner
   *
   */
  public static String getUserAddress(Scanner sc) {
    String address;
    while (true) {
      System.out.print("Enter Address: ");
      address = sc.nextLine();
      if (ValidationServiceHelper.validateAddress(address)) {
        return address;
      } else {
        System.out.println("Invalid Address");
      }
    }
  }

  /**
   * get user age.
   * @param sc represents scanner
   *
   */
  public static int getUserAge(Scanner sc) {
    int age;
    while (true) {
      try {
        System.out.print("Enter Age: ");
        age = sc.nextInt();
        if (ValidationServiceHelper.validateAge(age)) {
          return age;
        }
      } catch (InputMismatchException exception) {
        System.out.println("Input type mismatch");
        sc.nextLine();
      }
    }
  }

  /**
   * get user roll number.
   * @param rolls represents rolls
   * @param sc represents scanner
   *
   */
  public static int getUserRoll(List<Integer> rolls, Scanner sc) {
    int roll;
    while (true) {
      try {
        System.out.print("Enter Roll: ");
        roll = sc.nextInt();
        if (ValidationServiceHelper.validateRoll(rolls, roll)) {
          return roll;
        }
      } catch (InputMismatchException exception) {
        System.out.println("Input type mismatch");
        sc.nextLine();
      }
    }
  }

  /**
   * get user courses.
   * @param sc represents scanner
   *
   */
  public static char[] getUserCourses(Scanner sc) {
    char[] courses = new char[4];
    int index = 0;
    while (index != 4) {
      char ch;
      System.out.print("Enter Course: ");
      ch = sc.next().charAt(0);
      if (ValidationServiceHelper.validateCourse(ch)) {
        courses[index++] = ch;
      }
    }
    return courses;
  }
}
