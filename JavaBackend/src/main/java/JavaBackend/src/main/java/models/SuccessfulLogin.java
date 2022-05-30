package models;

public class SuccessfulLogin {

    private int permID;
    private int loginID;
    private int userID;
    private String username;
    private String passcode;
    private String adminPerm;
    private String generalUser;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public SuccessfulLogin(){ }

    public int getPermID() {
        return permID;
    }

    public void setPermID(int permID) {
        this.permID = permID;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getAdminPerm() {
        return adminPerm;
    }

    public void setAdminPerm(String adminPerm) {
        this.adminPerm = adminPerm;
    }

    public String getGeneralUser() {
        return generalUser;
    }

    public void setGeneralUser(String generalUser) {
        this.generalUser = generalUser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
