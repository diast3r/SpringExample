package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController // json 등의 응답만 할 것이므로 restcontroller으로 사용.
public class Lesson07Ex01RestController {
	@Autowired
	private StudentBO studentBO; // lesson04의 StudentBO
	
	// C: Create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "조경아";
		String phoneNumber = "010-1122-2354";
		String email = "jka@naver.com";
		String dreamJob = "강사";
		
		// save된 객체를 리턴하므로 id값이 채워진 상태로 받아옴.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: Update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 5인 레코드의 dreamJob을 "디자이너"로 변경
		// TODO BO에 메소드 구현
		return studentBO.updateStudentDreamJobById(5, "디자이너");
	}
	
	// D: Delete
	// Delete는 반환하는 객체가 없으므로 우리가 원하는 String으로 출력할 것임.
	@GetMapping("/delete")
	public String delte() {
		// id 5번인 레코드 삭제
		studentBO.deleteStudentById(5);
		return "삭제 완료";
	}
}
