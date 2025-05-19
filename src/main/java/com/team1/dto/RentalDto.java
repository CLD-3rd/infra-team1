package com.team1.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class RentalDto {
	
	private Long rentNo;
	private Long userNo;
	private Long oaccNo;
	private Timestamp rstart;
	private Date rexpiry;
	
}
