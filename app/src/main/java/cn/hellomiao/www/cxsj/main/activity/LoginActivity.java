package cn.hellomiao.www.cxsj.main.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cn.hellomiao.www.cxsj.R;
import cn.hellomiao.www.cxsj.main.entity.ResponseMsg;
import cn.hellomiao.www.cxsj.main.entity.User;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //定义控件
    private EditText et_userId;
    private EditText et_password;
    private Button bt_login;
    private Button bt_register;

    //定义变量
    private String userId;
    private String password;
    private int userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化控件
        setupUI();
        //初始化按钮监听事件
        setupListenEvent();
    }

    private void setupUI() {
        et_userId = (EditText) findViewById(R.id.editText);
        et_password = (EditText) findViewById(R.id.editText2);
        bt_login = (Button) findViewById(R.id.button);
        bt_register = (Button) findViewById(R.id.button2);
    }

    private void setupListenEvent() {
        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                //登录按钮触发事件
                toLogin();
                break;
            case R.id.button2:
                //注册按钮触发事件
                toRegister();
                break;
        }
    }

    private void toLogin() {
        //第一步：获取用户输入
        userId = et_userId.getText().toString();
        password = et_password.getText().toString();

        //第二步：检验输入数据格式是否正确
        if (userId == "") {
            Toast.makeText(getApplicationContext(), "请输入账号", Toast.LENGTH_SHORT).show();
            //继续进行下去没有意义，直接跳出就不会继续执行
            return;
        }
        if (password == "") {
            Toast.makeText(getApplicationContext(), "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        //第三步：发起网络请求

        //创建请求客户端
        OkHttpClient mOkHttpClient=new OkHttpClient();

        //创建请求体(传入参数)
        RequestBody formBody = new FormBody.Builder()
                .add("userId",userId)
                .add("password",password)
                .build();

        //创建请求
        Request request = new Request.Builder()
                //接口地址
                .url("http://www.hellomiao.cn:8080/api/main/login")
                //post方式发送请求体
                .post(formBody)
                .build();

        //创建响应
        Call call = mOkHttpClient.newCall(request);

        //异步方式接收反馈（同步占用主线程，会容易阻塞线程，不推荐使用）
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //请求失败执行这里
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //将返回数据转成String格式
                String json = response.body().string();
                Gson gson = new Gson();
                final ResponseMsg responseMsg = gson.fromJson(json, ResponseMsg.class);
                final User user = gson.fromJson(json, User.class);
                //更新主线程
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //更新主线程
                        if(responseMsg.getStatus() == 1) {
                            toHome(user.getUserType());
                        }else{
                            Toast.makeText(getApplicationContext(), "请求成功:" + responseMsg.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    private void toRegister() {
        //跳转注册
    }

    //跳转到主页
    private void toHome(int userType){

        //使用SharedPreferences存储数据
        SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("userId", userId);
        editor.putString("password", password);
        editor.commit();

        //使用使用SharedPreferences取数据
//        SharedPreferences preferences2 = getSharedPreferences("user", Context.MODE_PRIVATE);
//        String userId = preferences.getString("userId","");
//        String password =preferences.getString("password", "");

        if(userType == 1){
            //跳转到leader主页 -> 老板

        }else if(userType == 2){
            //跳转到manager主页 -> 经理

        }else if(userType == 3){
            //跳转到employee主页 -> 员工

        }else{
            //跳转到ordinary主页 -> 普通注册用户
        }
    }
}

