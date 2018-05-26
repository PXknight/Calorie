package com.zucc.pjx1337.calorie.BmobBean;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {

    String sex;
    Integer age;
    Integer height;
    Float weight;
    Integer SportsNum;
    Integer bmr;
    Integer bmr2;
    public Integer getBmr2() {
        return bmr2;
    }

    public void setBmr2(Integer bmr2) {
        this.bmr2 = bmr2;
    }



    public Integer getBmr() {
        return bmr;
    }

    public void setBmr(Integer bmr) {
        this.bmr = bmr;
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getSportsNum() {
        return SportsNum;
    }

    public void setSportsNum(Integer sportsNum) {
        SportsNum = sportsNum;
    }
}
