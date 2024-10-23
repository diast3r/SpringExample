package com.example.lesson04.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data // lombok의 어노테이션. getter, seteter를 자동으로 설정해줌. 
public class User {
	private int id;
	private String name;
	private String yyyymmdd;
	private String email;
	private String introduce;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
