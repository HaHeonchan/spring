package com.seq.login.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // 기본 정보
    @Column(nullable = false, unique = true)
    public String name;          // 이름

    @Column(nullable = false)
    public String password;

//    private String birth;         // 생년월일
//    private String gender;        // 성별
//
//    // 연락처 정보
//    private String address;       // 주소지
//    private String phone;         // 휴대전화 번호
//    private String email;         // 이메일
//
//    // 학력 정보
//    private String university;    // 학교명
//    private String major;         // 전공명
//    private int admission;     // 입학년도
//    private int graduation;    // 졸업연도
//    private String academicStatus; // 학적상태
//
//    // 희망 직무 및 자기소개
//    private String skill;         // 스킬
//    private String desiredJob;    // 희망 직무
//    private String experience;    // 경험 및 활동이력
//    private String antecedents;   // 경력
//    private String qualifications; // 자격 및 수상
//    private String about;         // 자기소개 (500자 제한)
}
