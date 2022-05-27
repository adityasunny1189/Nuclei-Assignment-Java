package utility;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UtilityClass {
    public static List<User> Decode(String jsonString) {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
        List<User> users = gson.fromJson(jsonString, userListType);
        return users;
    }

    public static String Encode(List<User> users) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String jsonString = gson.toJson(users);
        return jsonString;
    }
}
