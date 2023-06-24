package com.ingubook.service;


import com.ingubook.dto.BorrowHistoryModify;
import com.ingubook.dto.BorrowHistoryRegister;
import com.ingubook.dto.BorrowHistory;
import com.ingubook.mapper.BorrowHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookBorrowService {

    private final BorrowHistoryMapper borrowHistoryMapper;

    public List<BorrowHistory> findAllHistoryByBookId(Long bookId){

        return borrowHistoryMapper.findAllByBookId(bookId);
    }

    public void borrowByBookIdAndUserId(Long bookId, Long userId){

        borrowHistoryMapper.save(createNewBorrowHistory(bookId, userId));
    }

    public BorrowHistoryRegister createNewBorrowHistory(Long bookId, Long userId){

        return BorrowHistoryRegister.builder()
                .bookId(bookId)
                .userId(userId)
                .build();
    }

    public BorrowHistory findOneHistoryByBookIdOrderByCreatedDateDCES(Long bookId){

        return borrowHistoryMapper.findByBookIdOderByColumnNameAndOrderValue(bookId, "created_date", "DESC");
    }

    public void returnByBorrowId(Long id) throws IllegalArgumentException{

        Optional.ofNullable(borrowHistoryMapper.findById(id))
                .ifPresentOrElse(
                        (originalBorrowHistory) -> {

                            borrowHistoryMapper.update(getBorrowHistoryForReturn(originalBorrowHistory.getId()));
                        },
                        () -> {

                            throw new IllegalArgumentException();
                        }
                );
    }

    public BorrowHistoryModify getBorrowHistoryForReturn(Long borrowId){

        LocalDateTime now = LocalDateTime.now();

        return BorrowHistoryModify.builder()
                .id(borrowId)
                .returnDate(now)
                .modifiedDate(now)
                .status("returned")
                .build();
    }
}
