package com.team1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class OttAccountDto {
	
	private Integer oaccNo;
    private Integer ottNo;
    private String email;
    private String password;

}
