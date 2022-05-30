package models;

/**
 * display class.
 */
public class Display {
  /**
   * display details.
   */
  private final String displayDetails;

  /**
   * invalid choice.
   */
  private final String invalidChoice;

  /**
   * user details header.
   */
  private final String userDetailHeader;

  /**
   * user details.
   */
  private final String userDetails;

  /**
   * invalid roll.
   */
  private final String invalidRoll;

  /**
   * input roll.
   */
  private final String inputRoll;

  /**
   * display users by.
   */
  private final String displayUserBy;

  /**
   * Display constructor.
   *
   */
  public Display() {
    this.displayDetails = "Options:\n1. Add\n2. Display\n3. Delete\n4. Save\n5. Exit\nChoice: ";
    this.invalidChoice = "Invalid Choice";
    this.userDetailHeader = "Name\tRoll\tAge\tAddress\tCourses\n";
    this.userDetails = "%s\t%d\t%d\t%s\t%s\n";
    this.invalidRoll = "Invalid roll number";
    this.inputRoll = "Enter roll no: ";
    this.displayUserBy = "Display By \n1. Name\n2. Age\n3. Roll\nChoice: ";
  }

  public String getDisplayUserBy() {
    return displayUserBy;
  }

  public String getDisplayDetails() {
    return displayDetails;
  }

  public String getInvalidChoice() {
    return invalidChoice;
  }

  public String getUserDetails() {
    return userDetails;
  }

  public String getUserDetailHeader() {
    return userDetailHeader;
  }

  public String getInvalidRoll() {
    return invalidRoll;
  }

  public String getInputRoll() {
    return inputRoll;
  }
}
