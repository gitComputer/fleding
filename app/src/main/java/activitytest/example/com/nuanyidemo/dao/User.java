package activitytest.example.com.nuanyidemo.dao;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName ( "id" )
    private long id;
    @SerializedName ( "userName" )
    private String userName;
    @SerializedName ( "passWord" )
    private String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
