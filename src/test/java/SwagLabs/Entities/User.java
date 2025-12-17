package SwagLabs.Entities;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class User {

    private String username;
    private String password;

    public User(@NonNull String username, @Nullable String password) {
        this.username = username;
        this.password = "secret_sauce";
    }

    public String getUsername() { return username; }
    public void setUsername(String username) {
        if(username.isEmpty()) {
            throw new NullPointerException("Username cannot be null");
        }

        if(username.equals(this.username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        this.username = username;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        if(password.isEmpty()) {
            throw new NullPointerException("Password cannot be null");
        }

        if(password.equals(this.password)) {
            throw new IllegalArgumentException("Password already exists");
        }
        this.password = password;
    }

}
