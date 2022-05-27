import models.User;
import services.Services;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        String filePath = "users.json";

        // load users from the file
        List<User> users = Services.LoadUsers(filePath);

        // get all occupied roll numbers
        List<Integer> rolls = Services.LoadRollNum(users);


    }
}
