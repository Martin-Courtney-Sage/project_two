package models;

import java.util.Objects;

public class Users {

    private int userID;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    public Users(){}

    public Users(int userID, String firstname, String lastname, String email, String phone){
        this.userID = userID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    @Override
    public String toString() {
        return "Users{" +
                "userID=" + userID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userID == users.userID && Objects.equals(firstname, users.firstname) && Objects.equals(lastname, users.lastname) && Objects.equals(email, users.email) && Objects.equals(phone, users.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, firstname, lastname, email, phone);
    }

    //    public String toJSONString() {
//        return "{" +
//                "userID:" + this.userID + "," +
//                "firstname:" + this.firstname + "," +
//                "lastname:" + this.lastname + "," +
//                "email:" + this.email + "," +
//                "phone:" + this.phone +
//                "}";
//    }

}
