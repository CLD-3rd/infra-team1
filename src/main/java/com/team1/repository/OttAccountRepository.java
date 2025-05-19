package com.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.OttAccount;

@Repository
public interface OttAccountRepository extends JpaRepository<OttAccount, Long> {

}
