package com.ingubook.domain;

import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;


@Data
public class BookDTO {
    Long id; // 식별자
    String isbn; // 도서번호
    String title; // 제목
    String authors; // 저자(들)
    String publisher; // 출판사
    String translators; // 번역가(들)
    Long price; // 가격
    String info; // 도서소개
    LocalDateTime publicationDate; // 발간일
    String thumbnail; // 도서표지좌표
    LocalDateTime createdDate; // 등록일
    LocalDateTime modifiedDate; // 수정일
    String status; // 상태 => 대출불가능, 대출가능
}
