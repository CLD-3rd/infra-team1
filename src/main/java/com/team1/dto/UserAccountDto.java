package com.team1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserAccountDto {
	
	private Long userNo;
    private String uid;
    private String upw;
    private String role;

}
