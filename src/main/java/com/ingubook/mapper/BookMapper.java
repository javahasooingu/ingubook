package com.ingubook.mapper;

import com.ingubook.dto.BookModifyRequest;
import com.ingubook.dto.BookRegisterRequest;
import com.ingubook.dto.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BookMapper {

    void save(BookRegisterRequest book);
    List<Book> findAll();
    Book findById(@Param("id") Long id);
    Book findByIsbn(@Param("isbn") String isbn);
    void update(BookModifyRequest book);
    void updateStatusById(@Param("id") Long id, @Param("status") String status, @Param("modifiedDate") LocalDateTime modifiedDate);
}
