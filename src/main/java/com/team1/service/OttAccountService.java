package com.team1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.repository.OttAccountRepository;
import com.team1.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OttAccountService {
	
	private final OttAccountRepository ottAccountRepository;

}
