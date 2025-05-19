package com.team1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/ott-acc-list")
	@ResponseBody
	public List<OttAccountDto> getAllAccounts() {
		return ottAccountService.getAllAccounts();
	}
	
}
