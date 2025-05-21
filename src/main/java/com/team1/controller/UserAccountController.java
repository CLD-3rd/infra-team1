package com.team1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.entity.UserAccount;
import com.team1.repository.UserAccountRepository;
import com.team1.service.UserAccountService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
// @RequestMapping("/users")
public class UserAccountController {
	
	private final UserAccountService userAccountService;
	
//	
//	@GetMapping({"/","/{userno}"})
//	public String homePage() {
//	    return "index"; // templates/index.html
//	}
//	bugfix : homepage 에서 userno를 받는 메서드가 없는문제 수정 - 김재신
	@GetMapping({"/","/{userno}"})
	public String homePage(@PathVariable(required = false) Long userno, HttpSession session) {
	    return "index"; // templates/index.html
	}
	
	//로그인 기본 페이지
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // templates/login.html
    }
    // 로그인 시도 - 원서희
    @PostMapping("/login")
//    public ModelAndView login(@RequestParam String uid, @RequestParam String upw) {
//        UserAccount user = userAccountService.authenticate(uid, upw);
//        if (user != null) {
//            return new ModelAndView("redirect:/");
//        } else {
//            ModelAndView mav = new ModelAndView("login");
//            mav.addObject("error", "아이디 또는 비밀번호가 틀렸습니다.");
//            return mav;
//        }
//    }
    // 로그인 시도 로직 + 세션 기능 추가
    public ModelAndView login(@RequestParam String uid,
                              @RequestParam String upw,
                              HttpSession session) {

        // userService.authenticate는 로그인 인증 함수!
        UserAccount user = userAccountService.authenticate(uid, upw);

        if (user != null) {
            session.setAttribute("loginUser", user);
            // 로그인 성공하면 /ott/{userno}로 이동하게 만들어야 함
            return new ModelAndView("redirect:/" + user.getUserNo());
        } else {
            // 로그인 실패하면 다시 로그인 페이지로
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return mav;
        }
    }
    
// ----------------------------------------------------------------------------
    
    // 회원가입 기본페이지
    @GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // templates/signup.html 을 보여줌
    }
    
    // 회원가입 - 원서희
    @PostMapping("/signup")
    public String userSignup(@RequestParam("uid") String uid,
    							@RequestParam("upw") String upw,
    							RedirectAttributes redirectAttributes) {
    	
        if (userAccountService.isUidDuplicated(uid)) {
        	redirectAttributes.addFlashAttribute("errorMessage", "아이디가 이미 존재합니다. 다른 아이디를 사용해주세요.");
            return "redirect:/signup";  // forward 사용
        }

        // 회원가입 로직 처리 
        System.out.println("회원가입 정보: " + uid + ", " + upw);
        UserAccount user = UserAccount.builder()
                .uid(uid)
                .upw(upw)
                .role("user") // 기본 권한
                .build();
        userAccountService.save(user);

        // 회원가입 후 이동할 페이지 (예: 로그인 페이지)
        return "redirect:/";
    }
    // 로그아웃 - 김재신 : 세션제거 후 / 로 리다이렉트
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 제거
        return "redirect:/"; // 홈으로 리다이렉트
    }
    
    
}
