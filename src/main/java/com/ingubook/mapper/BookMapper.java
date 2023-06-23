package com.ingubook.mapper;

import com.ingubook.domain.BookDTO;
import com.ingubook.domain.BookVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BookMapper {

    void save(BookDTO bookDto);
    List<BookVO> findAll();
    BookVO findById(@Param("id") Long id);
    void update(BookDTO bookDto);
    void updateStatusById(@Param("id") Long id, @Param("status") String status, @Param("modifiedDate") LocalDateTime modifiedDate);
}
