package models;

import java.util.Objects;

public class Login {

    private int loginID;
    private int userID;
    private String username;
    private String passcode;


    public Login(){}

    public Login(int loginID, int userID, String username, String passcode){
        this.loginID = loginID;
        this.userID = userID;
        this.username = username;
        this.passcode = passcode;
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

    @Override
    public String toString() {
        return "Login{" +
                "loginID=" + loginID +
                ", userID=" + userID +
                ", username='" + username + '\'' +
                ", passcode='" + passcode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return loginID == login.loginID && userID == login.userID && Objects.equals(username, login.username) && Objects.equals(passcode, login.passcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginID, userID, username, passcode);
    }

    //    public String toJSONString(){
//
//        return "{" +
//                "loginID:"+this.loginID+","+
//                "userID:"+this.userID+","+
//                "username:"+this.username+","+
//                "passcode:"+this.passcode+
//                "}";
//
//    }

}
