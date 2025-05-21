package com.team1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.OttAccount;
import com.team1.entity.OttPlatform;

@Repository
public interface OttAccountRepository extends JpaRepository<OttAccount, Long> {
	 // 선택한 플랫폼에 해당하는 계정 반환
    Optional<OttAccount> findFirstByOttNo_OttNo(Long ottNo);
    
	// 특정 플랫폼 계정만 조회
 	List<OttAccount> findByOttNo(OttPlatform ottPlatform);
 	
}
