package com.zucc.pjx1337.calorie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zucc.pjx1337.calorie.BmobBean.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;


public class LoginActivity extends BaseActivity {
    @BindView(R.id.user_edit)EditText userEdit;
    @BindView(R.id.password_edit)EditText passwordEdit;
    @BindView(R.id.login_button)Button loginButton;
    @BindView(R.id.register_button)Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "2bb3660521363b48107c86a9bc0401a1");
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.login_button,R.id.register_button})
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.login_button:
                login();
                break;
            case R.id.register_button:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }

    public void login(){

        BmobQuery<User> query = new BmobQuery<User>();
        if(userEdit.getText().toString().length()<1) {
            toast("请输入用户名");
            return;
        }
        if(passwordEdit.getText().toString().length()<1){
            toast("请输入密码");
            return;
            }
        User user = new User();
        user.setUsername(userEdit.getText().toString());
        user.setPassword(passwordEdit.getText().toString());
        user.login(new SaveListener<User>() {

            @Override
            public void done(User user, BmobException e) {
                if(e==null){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    toast("登录成功");
                    finish();

                }else{
                    toast("用户名密码错误");
                    loge(e);
                }
            }
        });

    }


}

