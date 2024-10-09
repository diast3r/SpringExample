package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@Controller
@RequestMapping("/lesson04/ex01")
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	// method : 요청 메소드 방식 지정. get방식 또는 그 외(post 계열) -> 생략 시 모든 요청 받음.
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String ex04_1() {
		return "lesson04/addUser"; // HTML의 경로
	}
	
	
	// 회원가입 데이터 DB insert => 결과 화면으로 이동
	// @PostMapping: @RequestMapping + method = RequestMethod.POST 
	// @GetMapping 도 당연히 있음.
	@PostMapping("/add-user")
	public String addUser(
			@RequestParam("name") String name, // 필수 파라미터
			@RequestParam("yyyymmdd") String yyyymmdd, // 필수 파라미터
			@RequestParam("email") String email, // 필수 파라미터
			@RequestParam(value = "introduce", required = false) String introduce) { // 비필수 파라미터
		
		// DB insert
		// 이 부분에서 에러가 많이 발생하므로 구현은 나중에 하고 우선 
		// request parameter들이 잘 들어왔는지 break point 설정해서 디버깅해보기. 
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면으로 이동
		return "lesson04/afterAddUser";
	}
	
}
