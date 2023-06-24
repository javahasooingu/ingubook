package com.ingubook.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BorrowHistoryRegister {
    @NotNull
    Long bookId; // 책번호
    @NotNull
    Long userId; // 유저번호
    LocalDateTime borrowDate = LocalDateTime.now(); // 대출일 : 자동완성
    LocalDateTime dueDate = LocalDateTime.now().plusDays(7); // 반납예정일 : 자동완성
    LocalDateTime createdDate = LocalDateTime.now(); // 생성일 : 자동완성
    String status = "on_borrow"; // 상태 => 대출중, 반납 : 자동완성

    @Builder
    public BorrowHistoryRegister(Long bookId, Long userId) {
        this.bookId = bookId;
        this.userId = userId;
    }
}
