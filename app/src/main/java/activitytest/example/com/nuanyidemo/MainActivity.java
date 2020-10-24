package activitytest.example.com.nuanyidemo;

import activitytest.example.com.nuanyidemo.bean.UserBean;
import activitytest.example.com.nuanyidemo.dao.User;
import activitytest.example.com.nuanyidemo.util.OkHttpUtil;
import activitytest.example.com.nuanyidemo.util.ParseJSON;
import activitytest.example.com.nuanyidemo.util.Url;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button login;
//    private Button rigistered;

    private EditText userName;
    private EditText passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        initView ();


        getUser ();
    }

    public void initView(){
        login=(Button)findViewById ( R.id. login);
//        rigistered=(Button)findViewById ( R.id.registered );
        userName=(EditText)findViewById ( R.id.userName );
        passWord=(EditText)findViewById ( R.id.passWord );
    }

    /**
     * 获取用户登录的信息
     */
    public void getUser(){

        login.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                User user=new User (  );

                user.setUserName ( userName.getText ().toString () );
                user.setPassWord ( passWord.getText ().toString () );

                sendMessage ( user, Url.LOGIN_ADDRESS );

            }
        } );

    }

    public void sendMessage(final User user, final String address){
        new Thread ( new Runnable () {
            @Override
            public void run() {
                OkHttpUtil.loginPost ( address, user, new Callback () {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        runOnUiThread ( new Runnable () {
                            @Override
                            public void run() {
                                Toast.makeText ( MainActivity.this,"网络连接失败",Toast.LENGTH_SHORT ).show ();
                            }
                        } );
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                        String res= Objects.requireNonNull ( response.body () ).string ();

                        System.out.println ( res );

                        UserBean userBean;
                        userBean = ParseJSON.parseUserWithGSON ( res );

                        final String loginStatus;

                        if (userBean.isResult_code ()){
                            loginStatus="登录成功";
                        }else {
                            loginStatus="登录失败,请重新输入密码";
                        }

                        runOnUiThread ( new Runnable () {
                            @Override
                            public void run() {
                                Toast.makeText ( MainActivity.this, loginStatus,Toast.LENGTH_SHORT ).show ();
                            }
                        } );
                    }
                } );
            }
        } ).start ();

    }


}
