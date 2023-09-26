package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー情報登録 リクエストデータ
 */
@Data
public class UserAddRequest implements Serializable {

    /**
     * 名前
     */
    @NotEmpty(message = "名前を入力してください")
    @Size(max = 100, message = "名前は100桁以内で入力してください")
    private String name;

    /**
     * パスワード
     */
    @NotEmpty(message = "パスワードを入力してください")
    @Size(max = 50, message = "パスワードは50桁以内で入力してください")
    private String password;
    
    /**
     * メールアドレス
     */
    @NotEmpty(message = "パスワードを入力してください")
    @Size(max = 50, message = "パスワードは50桁以内で入力してください")
    private String email;
}
