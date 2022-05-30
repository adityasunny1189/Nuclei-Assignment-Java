package models;

import java.util.Arrays;

/**
 * User class.
 */
public class UserClass {
  /**
   * name field.
   */
  private String name;

  /**
   * age field.
   */
  private int age;

  /**
   * address field.
   */
  private String address;

  /**
   * roll number field.
   */
  private int roll;

  /**
   * courses field.
   */
  private final char[] courses = new char[4];

  public int getRoll() {
    return roll;
  }

  public void setRoll(int roll) {
    this.roll = roll;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public char[] getCourses() {
    return Arrays.copyOf(courses, courses.length);
  }

  public void setCourses(char... courses) {
    System.arraycopy(courses, 0, this.courses, 0, courses.length);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
