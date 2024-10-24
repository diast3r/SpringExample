package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString // ToString 메소드 오버라이드 자동으로 해줌.
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor // 파라미터가 없는 생성자(기본)
@Getter // getter을 자동으로 작성해줌. @Setter도 있음.
@Builder(toBuilder = true) // @Setter 대신 사용하는 어노테이션. 이게 더 낫다고 함. toBuilder = true : 필드 수정(업데이터)를 허용함. 생략 시 false
@Entity // jpa 어노테이션. 이 객체는 엔티티다. DB-JPA 통신
@Table(name = "new_student") // jakarta.persistence.Table 선택, spring boot 2.x 버전에서는 jakarta가 아니라 javax라는 패키지명임.
public class StudentEntity {
	@Id // jakarta.persistence.Id 선택. PK임을 알려줌. 다른 unique key가 있다면 사용하지 않음.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert 시 방금 들어간 id 가져옴.
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // camel case로 돼있는 필드에는 작성해줘야 함.
	private String phoneNumber;
	
	private String email;

	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp // 값이 null이어도 insert 되는 시간으로 채워짐. 이게 없으면 db에 null이 들어갈 수 있음.
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // @CreationTimestamp 의 기능(insert) + update 시에 그 시간으로 채워줌. 
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
}
