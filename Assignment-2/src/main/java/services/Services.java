package services;

import models.User;
import utility.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Services {
    public static List<User> LoadUsers(String filePath) {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            int i;
            String jsonString = "";
            while ((i = reader.read()) != -1) {
                jsonString += (char)i;
            }
            users = UtilityClass.Decode(jsonString);
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

    public static void SaveUsers(List<User> users, String filePath) {
        String json = UtilityClass.Encode(users);
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
