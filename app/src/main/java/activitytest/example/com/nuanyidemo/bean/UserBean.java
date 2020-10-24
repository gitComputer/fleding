package activitytest.example.com.nuanyidemo.bean;

import com.google.gson.annotations.SerializedName;

import activitytest.example.com.nuanyidemo.dao.User;

/**
 *
 */
public class UserBean {

    /**
     * 返回信息
     */
    @SerializedName ( "msg" )
    private String msg;
    /**
     * 数据结果代码
     */
    @SerializedName ( "success" )
    private boolean result_code;


    /**
     * 结果集
     */
    @SerializedName ( "detail" )
    private User detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResult_code() {
        return result_code;
    }

    public void setResult_code(boolean result_code) {
        this.result_code = result_code;
    }

    public User getDetail() {
        return detail;
    }

    public void setDetail(User detail) {
        this.detail = detail;
    }
}
