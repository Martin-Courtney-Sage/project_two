package models;

import java.util.Objects;

public class Permissions {

    private int permID;
    private int loginID;
    private String adminPerm;
    private String generalUser;

    public Permissions(){}

    public Permissions(int permID, int loginID, String adminPerm, String generalUser){
        this.permID=permID;
        this.loginID=loginID;
        this.adminPerm=adminPerm;
        this.generalUser=generalUser;
    }

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

    @Override
    public String toString() {
        return "Permissions{" +
                "permID=" + permID +
                ", loginID=" + loginID +
                ", adminPerm='" + adminPerm + '\'' +
                ", generalUser='" + generalUser + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permissions that = (Permissions) o;
        return permID == that.permID && loginID == that.loginID && Objects.equals(adminPerm, that.adminPerm) && Objects.equals(generalUser, that.generalUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permID, loginID, adminPerm, generalUser);
    }

    //    public String toJSONString() {
//
//        return "{" +
//                "}";
//    }

}
