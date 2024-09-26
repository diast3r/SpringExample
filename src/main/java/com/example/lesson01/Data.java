package com.example.lesson01;

// Spring bean에 등록할 필요 없음. => 일반 java bean.
public class Data {
	// field
	private int id;
	private String name;
	
	// method
	// 클래스 내 빈 화면 우클릭-> source -> generate getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
