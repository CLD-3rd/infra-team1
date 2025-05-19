package com.team1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.OttAccount;
import com.team1.entity.Rental;
import com.team1.entity.UserAccount;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
	// 특정 사용자의 구독 목록 조회
    List<Rental> findByUser_UserNo(Long userno);

    // 중복 구독 방지- ott 계정을 이미 구독했는지 확인
    Optional<Rental> findByUserAndOttAccount(UserAccount user, OttAccount ottAccount);

}
