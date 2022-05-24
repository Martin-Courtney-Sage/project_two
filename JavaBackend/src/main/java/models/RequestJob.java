package models;

public class RequestJob {

    private int reqID;
    private int userID;
    private String positionApp;
    private String jobStatus;

    public RequestJob(){}

    public RequestJob(int reqID, int userID, String positionApp, String jobStatus){
        this.reqID=reqID;
        this.userID=userID;
        this.positionApp=positionApp;
        this.jobStatus=jobStatus;
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

    public String getPositionApp() {
        return positionApp;
    }

    public void setPositionApp(String positionApp) {
        this.positionApp = positionApp;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
}
