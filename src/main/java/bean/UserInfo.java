package bean;

public class UserInfo {
    private String fullname;
    private int userID;

    public UserInfo(String fullname, int userID) {
        this.fullname = fullname;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return fullname+" id->"+userID;
    }
}
