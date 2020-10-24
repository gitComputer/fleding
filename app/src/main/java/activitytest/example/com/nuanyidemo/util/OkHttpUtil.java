package activitytest.example.com.nuanyidemo.util;

import java.util.concurrent.TimeUnit;

import activitytest.example.com.nuanyidemo.dao.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 对okhttp的封装
 */
public class OkHttpUtil {

    public static void loginPost(String url, User user, Callback callback){

        //连接超时
        OkHttpClient client = new OkHttpClient.Builder ()
                //建立连接所用的时间
                .connectTimeout(30, TimeUnit.SECONDS)
                //网络请求的时间,从execute或者enqueue开始到还未请求完的时间
                .callTimeout(120, TimeUnit.SECONDS)
                //设置了这个值会定时的向服务器发送一个消息来保持长连接
                .pingInterval(5, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(60, TimeUnit.SECONDS)
                //写超时
                .writeTimeout(60, TimeUnit.SECONDS)
                .build ();

        //设置请求体
        RequestBody requestBody=new FormBody.Builder (  )
                .add ( "userName",user.getUserName () )
                .add ( "passWord",user.getPassWord () )
                .build ();


        Request request=new Request.Builder (  )
                .url ( url )
                .post ( requestBody )
                .build ();

        Call call=client.newCall ( request );
        call.enqueue ( callback );
    }

}
