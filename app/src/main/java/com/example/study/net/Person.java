package com.example.study.net;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author GhostKang
 * @description:
 * @date :2020/5/29 17:28
 */
public class Person {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    @SEX
    private int sex;

    public void setSex(@SEX int sex) {
        this.sex = sex;
    }

    @SEX
    public int getSex() {
        return sex;
    }

    public String getSexDes() {
        if (sex == MALE) {
            return "男";
        } else {
            return "女";
        }
    }
}

@IntDef({Person.MALE, Person.FEMALE})
@Retention(RetentionPolicy.SOURCE)
@interface SEX {
}

