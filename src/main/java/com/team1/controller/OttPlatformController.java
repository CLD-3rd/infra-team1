package com.team1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team1.service.OttPlatformService;
import com.team1.service.UserAccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ott")
public class OttPlatformController {
	
	private final OttPlatformService ottPlatformService;

}
