package com.example.lesson05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson05")
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("melon");
		fruits.add("grape");
		fruits.add("peach");
		fruits.add("mango");
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user1 = new HashMap<>();
		user1.put("name", "신보람");
		user1.put("age", 30);
		user1.put("hobby", "영화보기");
		users.add(user1);
		
		Map<String, Object> user2 = new HashMap<>();
		user2.put("name", "양준호");
		user2.put("age", 25);
		user2.put("hobby", "게임");
		users.add(user2);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		Date date = new Date(); // 옛날부터 쓰던 날짜 객체. 요새는 잘 안 씀.
		
		model.addAttribute("date", date);
		
		LocalDate localDate = LocalDate.now(); // 날짜(시간 미포함)객체. static에 올라와있으므로 new 필요 없음.
		model.addAttribute("localDate", localDate);
		
		LocalDateTime localDateTime = LocalDateTime.now(); // 날짜(시간 포함)객체. static에 올라와있으므로 new 필요 없음.
		model.addAttribute("localDateTime", localDateTime);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now(); // utc 표준시 객체.
		model.addAttribute("zonedDateTime", zonedDateTime);
		
		return "lesson05/ex03";
	}
}
