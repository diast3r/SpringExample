package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/lesson01/ex01") // 먼저 이 매핑으로 들어오고, 이후에 메소드별로 매핑된 주소를 이어붙임.
@Controller // spring bean임을 인식시켜주는 어노테이션. Spring이 관리하게 되고, 싱글턴 객체로 사용됨.
public class Lesson01Ex01Controller {
	
	// http://localhost:8080/lesson01/ex01/1
	// String 을 브라우저에 출력
	@ResponseBody // 리턴되는 String은 ResponseBody에 넣어지고 HTML 응답값이 됨.
	@RequestMapping("/1")
	public String ex01_1() {
		return "<h2>문자열을 ResponseBody에 보내는 예제</h2>";
	}
	
	// http://localhost:8080/lesson01/ex01/2
	// Map 리턴 => JSON String으로 변환됨
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> ex01_2() { // 이런 형태의 어노테이션도 가능함. 요새는 안 쓴다.
		Map<String, Object> map = new HashMap<>();
		map.put("딸기", 3);
		map.put("파인애플", 20);
		map.put("포도", 51);
		
		// map을 리턴하면 JSON String이 된다.
		// web starter에 jackson 라이브러리가 있기 때문.
		// build.gradle 파일 안에서 starter-web 확인 가능.
		return map;
	}
	
	
}
