package com.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.OttPlatform;

@Repository
public interface OttPlatformRepository extends JpaRepository<OttPlatform, Long> {

}
