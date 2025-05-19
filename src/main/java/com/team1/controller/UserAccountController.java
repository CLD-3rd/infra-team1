package com.team1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team1.entity.UserAccount;
import com.team1.service.UserAccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
// @RequestMapping("/users")
public class UserAccountController {
	
	private final UserAccountService userAccountService;
	
	@GetMapping("/")
	public String homePage() {
	    return "index"; // templates/index.html
	}
	
	//로그인 기본 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }
	
    // 로그인 시도 - 원서희
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String uid, @RequestParam String upw) {
//        System.out.println("uid: " + uid);
//        System.out.println("upw: " + upw);
        
        // userService.authenticate는 로그인 인증 함수!
        UserAccount user = userAccountService.authenticate(uid, upw);

        if (user != null) {
            // 로그인 성공하면 /ott/{userno}로 이동하게 만들어야 함
            return new ModelAndView("redirect:/");
        } else {
            // 로그인 실패하면 다시 로그인 페이지로
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return mav;
        }
    }
    
}
