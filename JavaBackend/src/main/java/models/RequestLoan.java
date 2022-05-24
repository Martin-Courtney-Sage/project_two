package models;

public class RequestLoan {

    private int reqID;
    private int userID;
    private int acctID;
    private double loanAmount;
    private String loanTerm;
    private String loanType;
    private String loanStatus;

    public RequestLoan(){}

    public RequestLoan(int reqID, int userID, int acctID, double loanAmount, String loanTerm, String loanType, String loanStatus){
        this.reqID=reqID;
        this.userID=userID;
        this.acctID=acctID;
        this.loanAmount=loanAmount;
        this.loanTerm=loanTerm;
        this.loanType=loanType;
        this.loanStatus=loanStatus;
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

    public int getAcctID() {
        return acctID;
    }

    public void setAcctID(int acctID) {
        this.acctID = acctID;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
}
