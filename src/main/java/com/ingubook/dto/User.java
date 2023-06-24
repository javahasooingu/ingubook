package com.ingubook.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class User {
    Long id; // 식별자
    String name; // 이름
    String loginId; // 책 빌릴 때 사용하는 아이디(중복확인)
    String password; // 비밀번호
    String phoneNumber; // 전화번호(중복확인)
    LocalDateTime createdDate; // 생성일
    LocalDateTime modifiedDate; // 수정일
    String status; // 상태 => 대출가능, 대출중, 불가능
}
