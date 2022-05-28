package models;

public class Display {
    private final String displayDetails;
    private final String invalidChoice;

    public Display() {
        this.displayDetails = "Options:\n1. Add User\n2. Display User\n3. Delete User\n4. Save Details\n5. Exit\nEnter your choice: ";
        this.invalidChoice = "Invalid Choice";
    }

    public String getDisplayDetails() {
        return displayDetails;
    }

    public String getInvalidChoice() {
        return invalidChoice;
    }
}
