package com.example.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// JPA의 repository (Mybatis의 mapper에 해당)은 어노테이션 안 붙임. 
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { 
	
	// 순수 JPA vs Spring Data JPA
	
	// Spring Data JPA : 기본적인 crud 기능 지원. extends Jparepository
	// => EntityManager가 해주는 일임.
	// public StudentEntity save(StudentEntity studentEntity); => 이런 메소드들이 자동으로 생성됨.
	
	// 만약 그냥 JPA였으면 메소드 직접 작성해줬어야 했을 것임.
}
