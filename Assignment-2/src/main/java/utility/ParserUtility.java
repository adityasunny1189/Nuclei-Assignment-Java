package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import models.User;

/**
 * utility class.
 */
public final class ParserUtility {
  private ParserUtility() {

  }

  /**
   * decode the json to object.
   * @param jsonString represents json string
   *
   */
  public static List<User> decode(String jsonString) {
    final Gson gson = new Gson();
    final Type userListType = new TypeToken<ArrayList<User>>() {
    }.getType();
    return gson.fromJson(jsonString, userListType);
  }

  /**
   * encode the objects to json.
   * @param users represents user object
   *
   */
  public static String encode(List<User> users) {
    final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    return gson.toJson(users);
  }
}
