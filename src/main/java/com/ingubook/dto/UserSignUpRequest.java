package com.ingubook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class UserSignUpRequest {
    @NotBlank @Pattern(regexp = "^[a-z가-힣]{2,15}$") // 영어 소문자 / 한글 2~15자리
    String name; // 이름
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9]{4,25}$") // 영어 대/소문자 + 숫자 4~25자리
    String loginId; // 책 빌릴 때 사용하는 아이디(중복확인)
    @NotBlank @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z0-9].{8,20}$") // 영어 대/소문자 + 숫자 각 1자리이상 필수 8~20자리
    String password; // 비밀번호
    @NotBlank @Pattern(regexp = "^[0-9]{10,11}$") // 숫자만 10,11자리
    String phoneNumber; // 전화번호(중복확인)
    LocalDateTime createdDate = LocalDateTime.now(); // 생성일 : 생성시 초기화
    String status = "available"; // 상태 => 대출가능, 대출중, 불가능 : 생성시 초기화;

    @Builder
    public UserSignUpRequest(String name, String loginId, String password, String phoneNumber) {
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
