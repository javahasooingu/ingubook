package com.ingubook.mapper;

import com.ingubook.dto.BorrowHistoryModify;
import com.ingubook.dto.BorrowHistoryRegister;
import com.ingubook.dto.BorrowHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BorrowHistoryMapper {

    void save(BorrowHistoryRegister borrowHistory);
    List<BorrowHistory> findAll();
    BorrowHistory findById(@Param("id") Long id);
    List<BorrowHistory> findAllByBookId(@Param("bookId") Long bookId);
    BorrowHistory findByBookIdOderByColumnNameAndOrderValue(@Param("bookId") Long bookId, @Param("columnName") String columnName, @Param("orderValue") String orderValue);
    List<BorrowHistory> findAllByUserId(@Param("userId") Long userId);
    void update(BorrowHistoryModify history);
}
