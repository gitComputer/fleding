package activitytest.example.com.nuanyidemo.util;

import com.google.gson.Gson;

import activitytest.example.com.nuanyidemo.bean.UserBean;


public class ParseJSON {

    /**
     * @param jsonData json字符串
     * @return 返回解析的userBean类
     */
    public static UserBean parseUserWithGSON(String jsonData){
        Gson gson=new Gson ();
        return gson.fromJson ( jsonData,UserBean.class );
    }
}
