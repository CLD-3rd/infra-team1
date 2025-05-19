package com.team1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team1.dto.OttAccountDto;
import com.team1.service.OttAccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
// @RequestMapping("/oacc")
public class OttAccountController {
	
	private final OttAccountService ottAccountService;
	
	// 전체 Ott 계정 조회
	@GetMapping("/ott-acc")
	@ResponseBody
	public List<OttAccountDto> getAllAccounts() {
		return ottAccountService.getAllAccounts();
	}
	
	// 특정 플랫폼 Ott 계정 조회
	@GetMapping("/ott-acc/platform/{ottno}")
	@ResponseBody
	public List<OttAccountDto> getByPlatform (@PathVariable Integer ottno) {
		return ottAccountService.getAccountByPlatform(ottno);
	}
	
}
