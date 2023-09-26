package com.example.demo.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserLoginRequest implements Serializable {

	//パスワード
	private String password;
	
	//メールアドレス
	private String email;

}
