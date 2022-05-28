package services;

import models.Display;
import models.User;
import utility.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Services {
    public static List<User> LoadUsers(String filePath) {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            int i;
            StringBuilder jsonString = new StringBuilder();
            while ((i = reader.read()) != -1) {
                jsonString.append((char) i);
            }
            users = UtilityClass.Decode(jsonString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<Integer> LoadRollNum(List<User> users) {
        List<Integer> rolls = new ArrayList<>();
        for (User user : users) {
            rolls.add(user.getRoll());
        }
        return rolls;
    }

    public static void SaveDetails(List<User> users, String filePath) {
        String json = UtilityClass.Encode(users);
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void DeleteUser(List<User> users, int roll) {
        users.removeIf(user -> user.getRoll() == roll);
    }

    public static void DisplayUsers(List<User> users, Display content) {
        System.out.print(content.getUserDetailHeader());
        for (User user : users) {
            System.out.printf(content.getUserDetails(), user.getName(), user.getRoll(), user.getAge(), user.getAddress(), Arrays.toString(user.getCourses()));
        }
    }

    public static void AddUser(List<User> users, List<Integer> rolls, Scanner sc) {
        User user = new User();
        String name, address;
        int age, roll;
        char[] courses;

        name = UserService.GetUserName(sc);
        address = UserService.GetUserAddress(sc);
        age = UserService.GetUserAge(sc);
        roll = UserService.GetUserRoll(rolls, sc);
        courses = UserService.GetUserCourses(sc);

        user.setName(name);
        user.setAddress(address);
        user.setAge(age);
        user.setRoll(roll);
        user.setCourses(courses);

        users.add(user);
        rolls.add(user.getRoll());
    }
}
