package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.UserAddRequest;
import com.example.demo.dto.UserLoginRequest;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserInfoController {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    private UserInfoService userInfoService;
    /**
     * 初期画面に遷移
     * @param 
     * @return 初期画面
     */
	@RequestMapping("/")
	public String index() {
		// index.htmlを表示
		return "user/index";
	}

    /**
     * 新規登録画面に遷移
     * @param model Model
     * @return 新規登録画面
     */
	@RequestMapping("/user/useradd")
	public String signup(Model model) {
		// useradd.htmlを表示
		model.addAttribute("userAddRequest", new UserAddRequest());
		return "user/useradd";
	}
    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ログイン画面
     */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute UserAddRequest userRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "user/useradd";
        }
        // ユーザー情報の登録
        userInfoService.save(userRequest);
   		model.addAttribute("userLoginRequest", new UserLoginRequest());
        return "user/login";
    }
    /**
     * ログイン画面に遷移
     * @param 
     * @return ログイン画面
     */
	@RequestMapping("/user/displaylogin")
	public String displayLogin(Model model) {
		// login.htmlを表示
		model.addAttribute("userLoginRequest", new UserLoginRequest());
		return "user/login";
	}
	/**
	 * ログイン機能
     * @param 
     * @return チャット画面
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String Login(@ModelAttribute UserLoginRequest userLoginRequest, Model model) {
		List<UserInfo> userList = userInfoService.login(userLoginRequest);
		//System.out.println(userList.);
		model.addAttribute("userlist",userList);
		return "user/chat";
	}

}
