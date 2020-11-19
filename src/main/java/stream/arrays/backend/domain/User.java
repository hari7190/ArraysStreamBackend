package stream.arrays.backend.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {
    @Id
    private int id;
    private String userName;
    private String password;
    private boolean isEnabled;
    private List<String> roles;

    public User(int id, String userName, String password, List<String> roles, boolean isEnabled) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isEnabled = isEnabled;
        this.roles = roles;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
