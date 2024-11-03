package com.seq.login;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // 기본 정보
    public String name;          // 이름
    public String birth;         // 생년월일
    public String gender;        // 성별

    // 연락처 정보
    public String address;       // 주소지
    public String phone;         // 휴대전화 번호
    public String email;         // 이메일

    // 학력 정보
    public String university;    // 학교명
    public String major;         // 전공명
    public int admission;     // 입학년도
    public int graduation;    // 졸업연도
    public String academicStatus; // 학적상태

    // 희망 직무 및 자기소개
    public String skill;         // 스킬
    public String desiredJob;    // 희망 직무
    public String experience;    // 경험 및 활동이력
    public String antecedents;   // 경력
    public String qualifications; // 자격 및 수상
    public String about;         // 자기소개 (500자 제한)
}
