package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Data
public class UserInfo implements Serializable {
    //ユーザーID
    private int userid;
    
    //名前
    private String name;
    
    //パスワード
    private String password;
    
    //メールアドレス
    private String email;
    
    //更新日時
    private Date updateDate;
    
    //登録日時
    private Date createDate;
    
}
