package app.oswaldogh.plazashop.Entities;

/**
 * Created by oswaldogh89 on 06/01/18.
 */

public class Credentials {
    private String token;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
