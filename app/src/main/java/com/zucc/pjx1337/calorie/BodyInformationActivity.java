package com.zucc.pjx1337.calorie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zucc.pjx1337.calorie.BmobBean.BaseActivity;
import com.zucc.pjx1337.calorie.BmobBean.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class BodyInformationActivity extends BaseActivity {

    @BindView(R.id.sex_edit)EditText sexEdit;
    @BindView(R.id.age_edit)EditText ageEdit;
    @BindView(R.id.height_edit)EditText heightEdit;
    @BindView(R.id.weight_edit)EditText weightEdit;
    @BindView(R.id.sportsNums_edit)EditText spNumsEdit;
    @BindView(R.id.sure_button)Button sureButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_information);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.sure_button) void test(){
        User newUser = new User();
        newUser.setSex(sexEdit.getText().toString());
        newUser.setAge(Integer.parseInt(ageEdit.getText().toString()));
        newUser.setHeight(Integer.parseInt(heightEdit.getText().toString()));
        newUser.setWeight(Float.parseFloat(weightEdit.getText().toString()));
        newUser.setBmr(bmrCalcu(newUser.getAge(),newUser.getHeight(),newUser.getWeight()));
        newUser.setSportsNum(Integer.parseInt(spNumsEdit.getText().toString()));
        newUser.setBmr2(bmr2Calcu(newUser.getBmr(),newUser.getSportsNum()));
        User user = User.getCurrentUser(User.class);
        newUser.update(user.getObjectId(),new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Intent intent = new Intent(BodyInformationActivity.this, MainActivity.class);
                    startActivity(intent);
                    toast("已成功添加个人资料");
                    finish();
                }else{
                    toast("添加个人资料失败:" + e.getMessage());
                }
            }
        });

    }

    private int bmrCalcu(int age,int height,float weight){
        int bmr=0;
        if(sexEdit.getText().toString().equals("man")){
            bmr=(int)(90+4.8*height+13.4*weight-5.7*age);
        }else if(sexEdit.getText().toString().equals("woman")){
            bmr=(int)(450+3.1*height+9.2*weight-4.3*age);
        }

        return bmr;
    }

    private int bmr2Calcu(int bmr,int sportsNum){
        int bmr2=0;
        if(sportsNum==0){
            bmr2=(int)(bmr*1.2);
        }else if(sportsNum>=1&&sportsNum<=3){
            bmr2=(int)(bmr*1.375);
        }else if(sportsNum>=3&&sportsNum<=5){
            bmr2=(int)(bmr*1.55);
        }else if(sportsNum>=6&&sportsNum<=7){
            bmr2=(int)(bmr*1725);
        }
        return bmr2;
    }
}

