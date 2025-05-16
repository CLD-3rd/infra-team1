package com.example.ottplatform.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userno;

    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false)
    private String upw;

    @Column(nullable = false)
    private String role; // "user" 또는 "admin"
}
