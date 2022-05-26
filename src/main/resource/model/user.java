package main.resource.model;

public class user {
    private String name;
    private int age;
    private String address;
    private int rollno;
    private char[] courses = new char[4];

    public user() {
    }

    public user(String name, int age, String addr, int roll, char[] courses) {
        this.name = name;
        this.age = age;
        this.address = addr;
        this.rollno = roll;
        this.courses = courses;
    }
}
