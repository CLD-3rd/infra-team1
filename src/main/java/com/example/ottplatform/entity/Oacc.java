package com.example.ottplatform.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "oacc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Oacc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private String accountType;
    private String status;
}