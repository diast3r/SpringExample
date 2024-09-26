package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


// HTML 화면으로 이동
@Controller // Spring bean, **html로 리턴할 때는 @ResponseBody가 절대 있으면 안 됨!!
public class Lesson01Ex02Controller {
	// http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() { // HTML의 경로를 String으로 리턴할 것임.
		// return 되는 String은 HTML의 경로
		// @ResponseBody가 없어야 한다.
		// thymleaf의 리소스 베이스 패키지 : src/main/resources/templates
		
		// 원하는 html파일의 경로: /templates/lesson01/ex02.html
		// 리턴하는 경로 형식 : templates 이후의 경로 작성.
		// '/'로 시작하지 않고, 파일 형식도 쓰지 않음.
		// 이 경로가 잘못되었으면 thymleaf에서 500에러를 띄어줌.
		// 이 경로의 파일을 찾는 것은 서버 내의 동작이므로 INTERNAL SERVER ERROR(500)에 해당함.
		return "lesson01/ex02"; // response, html view 경로
	}
}
