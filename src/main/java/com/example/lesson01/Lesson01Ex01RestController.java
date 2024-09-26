package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller과 @ResponseBody 어노테이션을 합친 역할.
public class Lesson01Ex01RestController {
	
	// http://localhost:8080/lesson01/ex01/3
	// RestController 사용했으므로 ResponseBody 어노테이션 따로 없어도 됨.
	@RequestMapping("/3")
	public String ex01_3() {
		return "<h3>@RestController 어노테이션 사용해서 String 리턴</h3>";
	}
	
	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "ZZZ");
		map.put("BBB", "ZZZ");
		map.put("CCC", "QQQ");
		return map;
	}
	
	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() { // Data 클래스는 직접 만들 것임.
		Data data = new Data(); // 직접 만든 클래스 -> java bean.
		data.setId(1);
		data.setName("양준호");
		
		return data; // Object -> JSON String 으로 출력됨.
	}
	
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data();
		data.setId(100);
		data.setName("바다");
		
		// ResponseEntity: 응답을 보낼 때 상태코드(200 ok와 같은.)를 임의로 지정해서 보낼 수 있게 해주는 객체. 
		// 생성자에 두 가지 필수 파라미터를 넣어야 함. 출력할 객체, 상태코드
		// 400번대 에러 발생 -> 클라이언트 잘못. 주소 오타 등 확인.
		// 500번대 에러 발생 -> 무조건 콘솔 확인.
		// http status code 검색해서 찾아보기.
		return new ResponseEntity<>(data, HttpStatus.CREATED); // 201번 에러 뿌려줌.
	}
	
	
	
	
	
	
	
}
