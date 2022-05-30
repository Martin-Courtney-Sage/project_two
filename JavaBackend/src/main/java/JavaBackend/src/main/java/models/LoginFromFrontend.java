package models;

public class LoginFromFrontend {

    private String username;
    private String passcode;

    public LoginFromFrontend(){}

    public LoginFromFrontend(String username, String passcode){
        this.username = username;
        this.passcode = passcode;
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
}
