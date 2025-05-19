package com.team1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.repository.OttPlatformRepository;
import com.team1.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OttPlatformService {
	
	private final OttPlatformRepository ottPlatformRepository;

}
