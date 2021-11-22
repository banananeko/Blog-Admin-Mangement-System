package ictgradschool.individualProject.swingclient.pojos;

public class UserQuery {

    private String username;
    private String password;

    public UserQuery() {
    }

    public UserQuery(String usename, String password) {
        this.username = usename;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
