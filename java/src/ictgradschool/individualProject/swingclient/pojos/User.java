package ictgradschool.individualProject.swingclient.pojos;

public class User {

    private int userId;
    private String username;
    private String password;
    private String bpassword;

    private String avatar;
    private String fname;
    private String lname;
    private String birthday;
    private String description;
    private String isAdmin;
    private String authToken;
    private int recipe_count;

    public String getBpassword() {
        return bpassword;
    }

    public void setBpassword(String recipeCount) {
        this.bpassword = recipeCount;
    }

    public int getRecipe_count() {
        return recipe_count;
    }

    public void setRecipe_count(int recipeCount) {
        this.recipe_count = recipeCount;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
