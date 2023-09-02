package model;

public class User {

    private String name;
    private int age;
    private int giftPoints;

    // no args constructor
    public User() {
    }

    // all args constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        giftPoints = 0;
    }

    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGiftPoints() {
        return giftPoints;
    }

    public void setGiftPoints(int giftPoints) {
        this.giftPoints = giftPoints;
    }

    public boolean ageIsOver(int age) {
        return this.age > age;
    }



}
