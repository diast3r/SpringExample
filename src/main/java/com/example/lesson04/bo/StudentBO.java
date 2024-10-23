package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA
	public StudentEntity addStudent(
			String name, String phoneNumber, 
			String email, String dreamJob) {
		// lombok에서 제공하는 builder 메소드 
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 가 entity에 있으므로 생략 가능.
				.build();
		
		
		// save(entity): insert해주는 repository의 메소드. 방금 insert한 객체를 다시 반환까지 해줌. 
		return studentRepository.save(student);
	}
	
	// jpa
	
	
	// mybatis 메소드
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	};
	
	// mybatis 메소드
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
