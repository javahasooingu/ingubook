package com.ingubook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class BookRegisterRequest {
    @NotBlank @Pattern(regexp = "^[a-z0-9]{11}$") // 영어 소문자 + 숫자 11자리
    String isbn; // 도서번호 (고유번호, 중복확인)
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9가-힣\s]{1,50}$") // 영어 대/소문자 + 숫자 + 한글 50자까지
    String title; // 제목
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9가-힣\s]{1,50}$") // 영어 대/소문자 + 숫자 + 한글 50자까지
    String authors; // 저자(들)
    @NotBlank @Pattern(regexp = "^[a-zA-Z0-9가-힣\s]{1,50}$") // 영어 대/소문자 + 숫자 + 한글 50자까지
    String publisher; // 출판사
    @Pattern(regexp = "^[a-zA-Z0-9가-힣\s]{1,50}$") // 영어 대/소문자 + 숫자 + 한글 50자까지
    String translators; // 번역가(들)
    Long price; // 가격
    @Pattern(regexp = "^[a-zA-Z0-9가-힣\s]{250}$") // 영어 대/소문자 + 숫자 + 한글 250자까지
    String info; // 도서소개
    LocalDateTime publicationDate; // 발간일
    LocalDateTime createdDate = LocalDateTime.now(); // 등록일 : 생성시 초기화
    String status = "available"; // 상태 => 대출중, 대출가능 : 생성시 초기화

    @Builder
    public BookRegisterRequest(String isbn, String title, String authors, String publisher, String translators, Long price, String info, LocalDateTime publicationDate) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.translators = translators;
        this.price = price;
        this.info = info;
        this.publicationDate = publicationDate;
    }
}
