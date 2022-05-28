package services;

import java.util.List;

public class ValidationService {
    public static boolean ValidateName(String name) {
        return name.length() > 5;
    }

    public static boolean ValidateAge(int age) {
        if (age <= 0) {
            return false;
        } else return age <= 100;
    }

    public static boolean ValidateAddress(String address) {
        return address.length() > 5;
    }

    public static boolean ValidateRoll(List<Integer> rolls, int roll) {
        if (roll <= 0) {
            return false;
        } else return !rolls.contains(roll);
    }

    public static boolean ValidateCourse(char course) {
        return course == 'A' || course == 'B' || course == 'C' || course == 'D' || course == 'E' || course == 'F';
    }
}
