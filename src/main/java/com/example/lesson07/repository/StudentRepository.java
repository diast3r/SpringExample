package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	// ex02/select1 => 메소드 규칙 => JPQL
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
	
	
	
	// ex02/select2 => JPQL(쿼리문처럼 생겼지만 db에 접근하지 않고 엔티티에게 조회하는 것임을 생각하기.) - sql 쿼리문 아님.
	// entity를 통해 조회하기 때문에 DBMS에 종속되지 않고, 알아서 맞춤 쿼리 생성해줄 수 있음.
	// JPQL문 안에서 변수를 사용할 때는 @Param으로 받아온 파라미터를 사용할 수 있고, 호출할 때는 :(변수명) 으로 작성.
	// @Param => JPQL문에 사용할 변수에 붙여줘야 함.
	// select * 가 아니라, select A(엔티티에 붙인 별칭) 으로 조회해야 함.
//	@Query(value = "select s from StudentEntity s where s.dreamJob = :dreamJob") // value = "(JPQL문)". 테이블명이 아니라 엔티티명으로 조회함.
//	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); // Mybatis의 @Param이 아님을 주의.
		
	
	// ex02/select2 -> SQL쿼리문(진짜로 Mysql에 접근하는 것.)
	// JPA가 쿼리문을 알아서 만드는 것이 아니라, 우리가 작성한 쿼리 그대로 수행해줌.
	// entity를 거치지 않고 직접 쿼리문을 날리기 때문에 DBMS에 종속됨. 다른 DB를 사용하면 별개로 작성해줘야 함.
	// @Query(nativeQuery = true) 지정해줘야 함.
	@Query(value = "select * from new_student where dreamJob = :dreamJob", nativeQuery = true)
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
}
