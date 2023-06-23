package com.ingubook.mapper;

import com.ingubook.domain.BorrowHistoryDTO;
import com.ingubook.domain.BorrowHistoryVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BorrowHistoryMapperTest {

    @Autowired
    private BorrowHistoryMapper borrowHistoryMapper;

    @Test
    @DisplayName("save")
    void save() {
        BorrowHistoryDTO newHistory = new BorrowHistoryDTO();

        newHistory.setBookId(1L);
        newHistory.setUserId(1L);
        newHistory.setBorrowDate(LocalDateTime.now());
        newHistory.setDueDate(LocalDateTime.now().plusDays(7));
        newHistory.setCreatedDate(LocalDateTime.now());
        newHistory.setStatus("on_borrow");

        borrowHistoryMapper.save(newHistory);
    }

    @Test
    @DisplayName("findById")
    void findById() {
        for (long i = 1; i <= 16; i++){
         Assertions.assertThat(borrowHistoryMapper.findById(i)).isNotNull();
        }
    }

    @Test
    @DisplayName("findByBookId")
    void findByBookId() {
        int beforeSize = borrowHistoryMapper.findByBookId(1L).size();
        
        BorrowHistoryDTO newHistory = new BorrowHistoryDTO();

        newHistory.setBookId(1L);
        newHistory.setUserId(1L);
        newHistory.setBorrowDate(LocalDateTime.now());
        newHistory.setDueDate(LocalDateTime.now().plusDays(7));
        newHistory.setCreatedDate(LocalDateTime.now());
        newHistory.setStatus("on_borrow");

        borrowHistoryMapper.save(newHistory);

        int afterSize = borrowHistoryMapper.findByBookId(1L).size();

        Assertions.assertThat(beforeSize).isEqualTo(afterSize - 1);
    }

    @Test
    @DisplayName("findByUserId")
    void findByUserId() {
        int beforeSize = borrowHistoryMapper.findByUserId(1L).size();

        BorrowHistoryDTO newHistory = new BorrowHistoryDTO();

        newHistory.setBookId(1L);
        newHistory.setUserId(1L);
        newHistory.setBorrowDate(LocalDateTime.now());
        newHistory.setDueDate(LocalDateTime.now().plusDays(7));
        newHistory.setCreatedDate(LocalDateTime.now());
        newHistory.setStatus("on_borrow");

        borrowHistoryMapper.save(newHistory);

        int afterSize = borrowHistoryMapper.findByUserId(1L).size();

        Assertions.assertThat(beforeSize).isEqualTo(afterSize - 1);
    }

    @Test
    @DisplayName("updateStatusById")
    void updateStatusById() {
        BorrowHistoryVO beforeHistory = borrowHistoryMapper.findById(1L);

        log.info(">>>>>>>>>>>>>{}", beforeHistory.getStatus());

        LocalDateTime now = LocalDateTime.now();

        borrowHistoryMapper.updateStatusById(1L,"returned", now);

        BorrowHistoryVO afterHistory = borrowHistoryMapper.findById(1L);

        log.info(">>>>>>>>>>>>>{}", afterHistory.getStatus());

        Assertions.assertThat(afterHistory.getStatus()).isEqualTo("returned");
        Assertions.assertThat(afterHistory.getModifiedDate()).isEqualTo(now);
    }

    @Test
    @DisplayName("updateDueDateById")
    void updateDueDateById() {
        BorrowHistoryVO beforeHistory = borrowHistoryMapper.findById(1L);

        log.info(">>>>>>>>>>>>>{}", beforeHistory.getDueDate());

        LocalDateTime modifiedDate = LocalDateTime.now().minusDays(388);
        LocalDateTime now = LocalDateTime.now();

        borrowHistoryMapper.updateDueDateById(1L,modifiedDate, now);

        BorrowHistoryVO afterHistory = borrowHistoryMapper.findById(1L);

        log.info(">>>>>>>>>>>>>{}", afterHistory.getDueDate());

        Assertions.assertThat(afterHistory.getDueDate()).isEqualTo(modifiedDate);
        Assertions.assertThat(afterHistory.getModifiedDate()).isEqualTo(now);
    }
}