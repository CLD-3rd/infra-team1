package com.team1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.dto.OttAccountDto;
import com.team1.entity.OttAccount;
import com.team1.entity.OttPlatform;
import com.team1.repository.OttAccountRepository;
import com.team1.repository.OttPlatformRepository;
import com.team1.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OttAccountService {
	
	private final OttAccountRepository ottAccountRepository;
	private final OttPlatformRepository ottPlatformRepository;

	public List<OttAccountDto> getAllAccounts() {
		return ottAccountRepository.findAll()
											.stream()
											.map(this::toDto)
											.collect(Collectors.toList());
	}
	
	private OttAccountDto toDto(OttAccount entity) {
		return new OttAccountDto(
				entity.getOaccNo().intValue(),
				entity.getOttNo().getOttNo().intValue(),
				entity.getEmail(),
				entity.getPassword()
				);
	}

	public List<OttAccountDto> getAccountByPlatform(Integer ottNo) {
		OttPlatform ottPlatform = ottPlatformRepository.findById(ottNo.longValue())
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Ott 플랫폼입니다."));
		
		List<OttAccount> accounts = ottAccountRepository.findByOttNo(ottPlatform);
		
		return accounts.stream()
								.map(this::toDto)
								.collect(Collectors.toList());
	}

}
