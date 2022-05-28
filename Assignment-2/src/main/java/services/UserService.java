package services;

import java.util.List;
import java.util.Scanner;

public class UserService {
    public static String GetUserName(Scanner sc) {
        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = sc.nextLine();
            if (ValidationService.ValidateName(name)) {
                return name;
            }
        }
    }

    public static String GetUserAddress(Scanner sc) {
        String address;
        while (true) {
            System.out.print("Enter Address: ");
            address = sc.nextLine();
            if (ValidationService.ValidateAddress(address)) {
                return address;
            }
        }
    }

    public static int GetUserAge(Scanner sc) {
        int age;
        while (true) {
            System.out.print("Enter Age: ");
            age = sc.nextInt();
            if (ValidationService.ValidateAge(age)) {
                return age;
            }
        }
    }

    public static int GetUserRoll(List<Integer> rolls, Scanner sc) {
        int roll;
        while (true) {
            System.out.print("Enter Roll: ");
            roll = sc.nextInt();
            if (ValidationService.ValidateRoll(rolls, roll)) {
                return roll;
            }
        }
    }

    public static char[] GetUserCourses(Scanner sc) {
        char[] courses = new char[4];
        int index = 0;
        while (index != 4) {
            char ch;
            System.out.print("Enter Course: ");
            ch = sc.next().charAt(0);
            if (ValidationService.ValidateCourse(ch)) {
                courses[index++] = ch;
            }
        }
        return courses;
    }
}
