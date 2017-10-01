package cn.hellomiao.www.cxsj.main.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.hellomiao.www.cxsj.R;


/* 实现思路：
 * 获取以上editText控件到输入
 * 判断：账号／密码／姓名 不能为空
 * 判断两个密码（密码和确认密码）是否一致
 * 判断完成后发送数据到接口 http://www.hellomiao.cn:8080/api/main/register 方法:post
 * 输入参数：userId password name phone
 * 返回参数：status msg
 * 注册成功（status = 1 ）跳转到登录页面
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupUI();
        //添加控件监听
        setListenEvent();
    }

    private void setupUI(){

    }

    private void setListenEvent(){

    }

    //点击事件具体实现
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_back:
                toBack();
                break;
            //继续实现其他控件到监听
        }
    }

    //返回
    private void toBack(){
        //通过销毁当前activity来实现返回
        RegisterActivity.this.finish();
    }

    //注册
    private void register(){

    }
}
