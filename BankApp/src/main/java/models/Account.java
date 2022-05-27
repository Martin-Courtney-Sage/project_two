package models;

import java.util.Objects;

public class Account {

    private int acctId;
    private String accounttype;
    private int userId;
    private double accountBalance;

    public Account() {
    }

    public Account(int acctId, String accounttype, int userId, double accountBalance) {
        this.acctId = acctId;
        this.accounttype = accounttype;
        this.userId = userId;
        this.accountBalance = accountBalance;
    }

    public int getAcctId() {
        return acctId;
    }

    public void setAcctId(int acctId) {
        this.acctId = acctId;
    }

    public String getAcct() {
        return accounttype;
    }

    public void setAcct(String accounttype) {
        this.accounttype = accounttype;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAcctBal() {
        return accountBalance;
    }

    public void setAcctBal(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return getAcctId() == account.getAcctId() && getUserId() == account.getUserId()
                && Double.compare(account.getAcctBal(), getAcctBal()) == 0 &&
                getAcct().equals(account.getAcct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAcctId(), getAcct(), getUserId(), getAcctBal());
    }

    @Override
    public String toString() {
        return "Account{" +
                "AcctId=" + acctId +
                ", accounttype='" + accounttype + '\'' +
                ", userId=" + userId +
                ", acctBal=" + accountBalance +
                '}';
    }
}