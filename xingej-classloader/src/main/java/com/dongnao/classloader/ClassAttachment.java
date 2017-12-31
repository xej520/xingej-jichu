package com.dongnao.classloader;

import java.util.Date;

//父类对象Date，提升通用域，所以这里随便找了一个父类，如Date
// 
public class ClassAttachment extends Date {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "----->欢迎大家来到动脑学院!<-----";
    }

}
