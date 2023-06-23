package com.ingubook.domain;

import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    Long id; // 식별자
    String name; // 이름
    String loginId; // 책 빌릴 때 사용하는 아이디(중복확인)
    String password; // 비밀번호
    String phoneNumber; // 전화번호(중복확인)
    Boolean isOverdue; // 연체되었는가?
    LocalDateTime overdueDate; // 연체로 인한 대출이 불가능한 기간
    String auth; // 권한
    LocalDateTime createdDate; // 생성일
    LocalDateTime modifiedDate; // 수정일
    String status; // 상태 => 대출중, 대출가능, 불가능
}
