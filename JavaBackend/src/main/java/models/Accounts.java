package models;

public class Accounts {

    private int acctID;
    private int userID;
    private String accountType;
    private double accountBalance;

    public Accounts(){}

    public Accounts(int acctID, int userID, String accountType, double accountBalance){
        this.acctID=acctID;
        this.userID=userID;
        this.accountType=accountType;
        this.accountBalance=accountBalance;
    }

    public int getAcctID() {
        return acctID;
    }

    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


}
