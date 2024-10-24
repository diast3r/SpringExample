package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	
	// mybatis 메소드
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	};
	
	// mybatis 메소드
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// jpa
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// jpa는 기존 데이터를 가져오고 업데이트를 수행함.
		// 업데이트 메소드가 따로 없고, 가져온 엔티티에 수정된 내용을 save함.
		// save()메소드 -> 파라미터로 받은 entity에 pk가 있으면 update. 없으면 insert 수행.
		
		// 기존 데이터 조회 - id로 entity
		// findById()는 Optional<StudentEntity> 반환.
		// Optional의 메소드인 .orElse(null): StudentEntity가 없다면 null 반환. 또는 다른 것으로 지정할 수 있음.
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		if (student != null) { // 조회된 데이터가 있을 때만 업데이트 진행.
			student = student.toBuilder() // toBuilder() 는 Entity에 Builder 설정에 tobuild = true 돼있어야 사용 가능.
				.dreamJob(dreamJob)
				.build();
			
			
			// 변경할 내용을 entity에 세팅 후 save(entity에 id가 포함돼있어 업데이트 수행.)
			student = studentRepository.save(student);
		}
		return student;
	}
	
	// Delete(JPA)
	public void deleteStudentById(int id) {
		// 방법 1. 삭제할 대상 select => 삭제
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		
//		if (student != null) {
//			studentRepository.delete(student); // student 객체에 id(pk)가 채워져 있으므로 그것을 통해 삭제함.
//			// 실제 수행된 쿼리문을 보면 where id = 5로 돼있음.
//		}
		
		// 방법 2. 삭제할 대상 select => 삭제
		Optional<StudentEntity> studentOptional = studentRepository.findById(id); // java.util의 Optional import
		studentOptional.ifPresent(s -> studentRepository.delete(s)); 
		// 람다식. 간단한 한 줄의 함수
		// if문을 대신할 수 있는 ifPresent.
	}
	
	
	
}
