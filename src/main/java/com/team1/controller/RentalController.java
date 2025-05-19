package com.team1.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team1.dto.RentalDto;
import com.team1.service.RentalService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
@RequestMapping("/rent")
public class RentalController {
	
	private final RentalService rentalService;

	// 사용자의 구독 신청 완료된 ott계정 목록 띄우기
	// 로그인 된 사용자만 접근 가능
	@GetMapping("/{userno}")
	public String showRentList(@PathVariable Long userno,
	                           HttpSession session,
	                           Model model) {
	    Object loginUser = session.getAttribute("loginUser"); // 세션에서 로그인 정보 확인
	    if (loginUser == null) {
	        return "redirect:/login";
	    }

	    List<RentalDto> rentList = rentalService.findByUserno(userno);
	    model.addAttribute("rentList", rentList);
	    model.addAttribute("userno", userno);
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
