package com.team1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.entity.UserAccount;
import com.team1.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAccountService {
	
	private final UserAccountRepository userAccountRepository;

    // 사용자 인증 (로그인 검증)
    public UserAccount authenticate(String uid, String upw) {
        return userAccountRepository.findByUidAndUpw(uid, upw);
    }

    // 회원가입 로직
    public void save(UserAccount user) {
        userAccountRepository.save(user); // DB에 저장
    }

    public boolean isUidDuplicated(String uid) {
        return userAccountRepository.findByUid(uid) != null;
    }


}
