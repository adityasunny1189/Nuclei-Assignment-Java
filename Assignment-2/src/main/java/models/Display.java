package models;

public class Display {
    private final String displayDetails;
    private final String invalidChoice;
    private final String userDetailHeader;
    private final String userDetails;
    private final String invalidRoll;
    private final String inputRoll;

    public Display() {
        this.displayDetails = "Options:\n1. Add User\n2. Display User\n3. Delete User\n4. Save Details\n5. Exit\nEnter your choice: ";
        this.invalidChoice = "Invalid Choice";
        this.userDetailHeader = "Name\tRoll\tAge\tAddress\tCourses\n";
        this.userDetails = "%s\t%d\t%d\t%s\t%s\n";
        this.invalidRoll = "Invalid roll number";
        this.inputRoll = "Enter roll no: ";
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
