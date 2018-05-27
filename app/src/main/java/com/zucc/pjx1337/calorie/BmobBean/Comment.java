package com.zucc.pjx1337.calorie.BmobBean;


import cn.bmob.v3.BmobObject;

public class Comment extends BmobObject {

    private String content;//评论内容

    private User user;//评论的用户，Pointer类型，一对一关系

    private Share share; //所评论的帖子，这里体现的是一对多的关系，一个评论只能属于一个微博
}
