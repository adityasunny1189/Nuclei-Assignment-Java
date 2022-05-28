package services;

import java.util.InputMismatchException;
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
            } else {
                System.out.println("Invalid Name");
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
            } else {
                System.out.println("Invalid Address");
            }
        }
    }

    public static int GetUserAge(Scanner sc) {
        int age;
        while (true) {
            try {
                System.out.print("Enter Age: ");
                age = sc.nextInt();
                if (ValidationService.ValidateAge(age)) {
                    return age;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Input type mismatch");
                sc.nextLine();
            }
        }
    }

    public static int GetUserRoll(List<Integer> rolls, Scanner sc) {
        int roll;
        while (true) {
            try {
                System.out.print("Enter Roll: ");
                roll = sc.nextInt();
                if (ValidationService.ValidateRoll(rolls, roll)) {
                    return roll;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Input type mismatch");
                sc.nextLine();
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
