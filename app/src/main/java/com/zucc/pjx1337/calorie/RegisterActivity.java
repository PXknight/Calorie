package com.zucc.pjx1337.calorie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zucc.pjx1337.calorie.BmobBean.BaseActivity;
import com.zucc.pjx1337.calorie.BmobBean.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.user_editR)EditText userEdit;
    @BindView(R.id.password_editR)EditText passwordEdit;
    @BindView(R.id.password_editR2)EditText passwordEdit2;
    @BindView(R.id.register_buttonR)Button registerButton;
    @BindView(R.id.back_buttonR)Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }




    @OnClick({R.id.register_buttonR,R.id.back_buttonR})
    public void onClick(View v){
        switch(v.getId()) {
            case R.id.register_buttonR:
            getEdit();
            break;
            case R.id.back_buttonR:
                Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            default:
                break;
        }
    }

    public void getEdit(){
        if(userEdit.getText().toString().length()<1){
            toast("用户名不能为空");
            return;
        }

        if(passwordEdit.getText().toString().length()<1){
            toast("密码不能为空");
            return;
        }

        if(!passwordEdit.getText().toString().equals(passwordEdit2.getText().toString())) {
            toast("请输入相同密码");
            return;
            }

        User user = new User();
        user.setUsername(userEdit.getText().toString());
        user.setPassword(passwordEdit.getText().toString());
        addSubscription(user.signUp(new SaveListener<User>() {
            @Override
            public void done(User s, BmobException e) {
                if(e==null){
                    Intent intent = new Intent(RegisterActivity.this, BodyInformationActivity.class);
                    startActivity(intent);
                    toast("注册成功,请填写个人资料");
                    finish();
                }else{
                    toast("该用户已存在");
                    loge(e);
                }
            }
        }));


    }


}
