package fr.insa.soa.Volunteers_rest;

public class UserRequest {
    private User user;
    private String password;

    // Getters et setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
