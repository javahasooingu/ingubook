package com.ingubook.domain;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BorrowHistoryVO {
    Long id; // 식별자
    Long bookId; // 책번호
    Long userId; // 유저번호
    LocalDateTime borrowDate; // 대출일
    LocalDateTime dueDate; // 반납예정일
    LocalDateTime returnDate; // 반납일
    LocalDateTime createdDate; // 생성일
    LocalDateTime modifiedDate; // 수정일
    String status; // 상태 => 대출중, 반납, 연체중
}
