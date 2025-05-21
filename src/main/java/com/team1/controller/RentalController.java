package com.team1.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.dto.RentalDto;
import com.team1.entity.UserAccount;
import com.team1.repository.UserAccountRepository;
import com.team1.service.RentalService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
@RequestMapping("/rent")
public class RentalController {
	
	private final RentalService rentalService;
	private final UserAccountRepository userAccountRepository;

	// 사용자의 구독 신청 완료된 ott계정 목록 띄우기
	// 로그인 된 사용자만 접근 가능
	@GetMapping("/{userno}")
	public String showRentList(@PathVariable Long userno,
	                           HttpSession session,
	                           Model model) {
		
		// 현재 로그인된 사용자 정보를 세션에서 가져옴
	    Object loginUser = session.getAttribute("loginUser"); 
	    // 로그인하지 않았다면 로그인 페이지로 리다이렉트
	    if (loginUser == null) {	
	        return "redirect:/login";
	    }
	    
	    // 유저 정보 조회
	    Optional<UserAccount> userOpt = userAccountRepository.findById(userno);
	    if (userOpt.isEmpty()) {
	        return "redirect:/login"; // 또는 에러 페이지로
	    }
	    UserAccount user = userOpt.get();
	    
	    
	    // 요청 경로에 포함된 userno 값을 기준으로 해당 유저의 구독 목록 조회
	    List<RentalDto> rentList = rentalService.findByUserno(userno);
	    
	    	    
	    model.addAttribute("rentList", rentList);
	    model.addAttribute("userno", userno);
	    // uid도 함께 모델에 전달
	    model.addAttribute("uid", user.getUid()); 
	    return "rent-status";
	}

    
    
    // 구독 취소
    @PostMapping("/cancel")
    public String cancelSubscription(@RequestParam("rentNo") Long rentNo,
                                     @RequestParam("userno") Long userno,
                                     RedirectAttributes redirectAttributes) {
        rentalService.deleteById(rentNo);
        redirectAttributes.addFlashAttribute("cancelSuccess", true);
        return "redirect:/rent/" + userno;
    }

}
