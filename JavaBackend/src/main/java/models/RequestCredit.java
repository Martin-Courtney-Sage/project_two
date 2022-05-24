package models;

public class RequestCredit {

    private int reqID;
    private int userID;
    private String cardType;
    private double creditLimit;
    private String reqStatus;

    public RequestCredit(){}

    public RequestCredit(int reqID, int userID, String cardType, double creditLimit, String reqStatus){
        this.reqID=reqID;
        this.userID=userID;
        this.cardType=cardType;
        this.creditLimit=creditLimit;
        this.reqStatus=reqStatus;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }
}
