package model;

public class User {
    private String idUser;
    private String name;

    public User(String idUser, String name) {
        this.idUser = idUser;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
