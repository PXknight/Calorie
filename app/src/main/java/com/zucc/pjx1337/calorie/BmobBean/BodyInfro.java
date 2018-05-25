package com.zucc.pjx1337.calorie.BmobBean;

import cn.bmob.v3.BmobObject;

public class BodyInfro extends BmobObject {

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
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

    public Integer getBmr() {
        return bmr;
    }

    public void setBmr(Integer bmr) {
        this.bmr = bmr;
    }

    String user;
    Boolean sex;
    Integer age;
    Integer height;
    Float weight;
    Integer SportsNum;
    Integer bmr;
}
