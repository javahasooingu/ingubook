package com.ingubook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class BorrowHistoryModify {
    Long id; // 식별자
    LocalDateTime returnDate; // 반납일
    LocalDateTime modifiedDate; // 수정일
    String status; // 상태 => 대출중, 반납

    @Builder
    public BorrowHistoryModify(Long id, Long bookId, Long userId, LocalDateTime returnDate, LocalDateTime modifiedDate, String status) {
        this.id = id;
        this.returnDate = returnDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }
}
