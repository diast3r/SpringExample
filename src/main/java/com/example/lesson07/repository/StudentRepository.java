package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// JPA의 repository (Mybatis의 mapper에 해당)은 어노테이션 안 붙임. 
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { 
	
	// 순수 JPA vs Spring Data JPA
	
	// JPQL : 엔티티에 조회함. db에 직접 접근하지 않고, EntityManager을 통해 조회함.
	
	// Spring Data JPA : 기본적인 crud 기능 지원. extends Jparepository
	// => EntityManager가 해주는 일임.
//	public StudentEntity save(StudentEntity studentEntity); => 이런 메소드들이 자동으로 생성됨.
//	public void delete(StudentEntity studentEntity);
	
//	public Optional<StudentEntity> findById(int id);
	// Optional<> : null 인지 아닌지에 따라 수행해주는 객체
	
	// 조회
//	public List<StudentEntity> findAll();
	
	// ex02/select1 => JPQL 메소드.
	// 메소드명을 JPQL 규칙에 맞게 만들면 알아서 Hibernate가 알아서 쿼리 생성해줄 것임.
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	// id 내림차순 3개 조회
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	// 이름으로 조회
	public List<StudentEntity> findByName(String name); // 파라미터 이름은 상관 없음.
	
	// 이름으로 조회(in 안에 있는 값으로 조회)
	public List<StudentEntity> findByNameIn(List<String> names);
	
	//
	public List<StudentEntity> findByNameAndDreamJob(String name1, String dreamJob222);

	public List<StudentEntity> findByEmailContains(String keyword);
	
	public List<StudentEntity> findByNameStartingWith(String keyword);
	
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	// 만약 그냥 JPA였으면 메소드 직접 작성해줬어야 했을 것임.
}
