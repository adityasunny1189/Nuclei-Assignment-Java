package models;

public class User {
    private String name;
    private int age;
    private String address;
    private int roll;
    private char[] courses = new char[4];

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setCourses(char[] courses) {
        this.courses = courses;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public char[] getCourses() {
        return courses;
    }

    public int getAge() {
        return age;
    }
}
