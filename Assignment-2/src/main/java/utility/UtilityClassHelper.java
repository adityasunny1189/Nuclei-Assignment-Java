package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import models.UserClass;

/**
 * utility class.
 */
public final class UtilityClassHelper {
  private UtilityClassHelper() {

  }

  /**
   * decode the json to object.
   * @param jsonString represents json string
   *
   */
  public static List<UserClass> decode(String jsonString) {
    final Gson gson = new Gson();
    final Type userListType = new TypeToken<ArrayList<UserClass>>() {
    }.getType();
    return gson.fromJson(jsonString, userListType);
  }

  /**
   * encode the objects to json.
   * @param userClasses represents user object
   *
   */
  public static String encode(List<UserClass> userClasses) {
    final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    return gson.toJson(userClasses);
  }
}
