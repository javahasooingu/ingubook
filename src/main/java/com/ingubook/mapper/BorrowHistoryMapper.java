package com.ingubook.mapper;

import com.ingubook.domain.BookVO;
import com.ingubook.domain.BorrowHistoryDTO;
import com.ingubook.domain.BorrowHistoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BorrowHistoryMapper {

    void save(BorrowHistoryDTO borrowHistoryDto);
    List<BorrowHistoryVO> findAll();
    BorrowHistoryVO findById(@Param("id") Long id);
    List<BorrowHistoryVO> findByBookId(@Param("bookId") Long bookId);
    List<BorrowHistoryVO> findByUserId(@Param("userId") Long userId);
    void updateStatusById(@Param("id") Long id, @Param("status") String status, @Param("modifiedDate") LocalDateTime modifiedDate);
    void updateDueDateById(@Param("id") Long id, @Param("dueDate") LocalDateTime dueDate, @Param("modifiedDate") LocalDateTime modifiedDate);
}
