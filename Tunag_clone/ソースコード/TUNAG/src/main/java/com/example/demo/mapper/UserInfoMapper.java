package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.dto.UserLoginRequest;
import com.example.demo.entity.UserInfo;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserInfoMapper {
	
    /**
     * ユーザー情報登録
     * @param userRequest 登録用リクエストデータ
     */
    void save(UserAddRequest userRequest);
    /**
     * ログイン
     */
    public List<UserInfo> login(UserLoginRequest userLoginRequest);
}
