package com.ingubook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class BookModifyRequest {
    @NotNull
    Long id; // 식별자
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
    LocalDateTime modifiedDate = LocalDateTime.now(); // 수정일 : 생성시 초기화
    @NotBlank
    String status; // 상태 => 대출중, 대출가능 : 생성시 초기화

    @Builder
    public BookModifyRequest(Long id,String isbn, String title, String authors, String publisher, String translators, Long price, String info, LocalDateTime publicationDate, String status) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.translators = translators;
        this.price = price;
        this.info = info;
        this.publicationDate = publicationDate;
        this.status = status;
    }
}
