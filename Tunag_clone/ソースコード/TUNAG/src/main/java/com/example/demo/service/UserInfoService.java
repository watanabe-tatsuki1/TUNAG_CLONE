package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.dto.UserLoginRequest;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;

/**
 * ユーザー情報 Service
 */
@Service
public class UserInfoService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * ユーザ新規登録
     * @param userAddRequest リクエストデータ
     */
    public void save(UserAddRequest userAddRequest) {
        userInfoMapper.save(userAddRequest);
    }
    /**
     * ログイン
     * @param userLoginRequest
     */
    public List<UserInfo> login(UserLoginRequest userLoginRequest) {
    	return userInfoMapper.login(userLoginRequest);
    }
}
