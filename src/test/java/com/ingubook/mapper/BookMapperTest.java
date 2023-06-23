package com.ingubook.mapper;

import com.ingubook.domain.BookDTO;
import com.ingubook.domain.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    @DisplayName("save")
    void save() {
        BookDTO newBook = new BookDTO();

        newBook.setIsbn("11111111111");
        newBook.setTitle("책제목1");
        newBook.setAuthors("저자1 저자2");
        newBook.setPublisher("출판사1");
        newBook.setTranslators("번역가1 번역가2");
        newBook.setPrice(123450L);
        newBook.setInfo("책 정보1");
        newBook.setPublicationDate(LocalDateTime.now());
        newBook.setThumbnail("book/thumbnail/" + LocalDateTime.now() + "/1");
        newBook.setStatus("available");

        bookMapper.save(newBook);
    }

    @Test
    @DisplayName("findById")
    void findById() {
        for(long i = 1; i <= 16; i++) {
            Assertions.assertThat(bookMapper.findById(i)).isNotNull();
        }
    }

    @Test
    @DisplayName("update")
    void update() {
        BookVO beforeBook = bookMapper.findById(1L);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>{}", beforeBook);

        BookDTO testBook = new BookDTO();

        testBook.setId(1L);
        testBook.setIsbn("01234567890");
        testBook.setTitle("책제목 test");
        testBook.setAuthors(beforeBook.getAuthors());
        testBook.setAuthors(beforeBook.getAuthors());
        testBook.setPublisher(beforeBook.getPublisher());
        testBook.setTranslators("저자1 저자2");
        testBook.setPrice(beforeBook.getPrice());
        testBook.setInfo(beforeBook.getInfo() + "test");
        testBook.setThumbnail(beforeBook.getThumbnail());
        testBook.setModifiedDate(LocalDateTime.now());
        testBook.setStatus(beforeBook.getStatus());

        bookMapper.update(testBook);

        BookVO afterBook = bookMapper.findById(1L);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>{}", beforeBook);

        Assertions.assertThat(afterBook.getIsbn()).isEqualTo("01234567890");
        Assertions.assertThat(afterBook.getInfo()).isEqualTo(beforeBook.getInfo() + "test");
    }

    @Test
    @DisplayName("updateStatusById")
    void updateStatusById() {
        BookVO beforeBook = bookMapper.findById(1L);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>{}", beforeBook);

        bookMapper.updateStatusById(1L, "on_borrow", LocalDateTime.now());

        BookVO afterBook = bookMapper.findById(1L);

        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>{}", beforeBook);

        Assertions.assertThat(beforeBook.getStatus()).isNotEqualTo(afterBook.getStatus());
        Assertions.assertThat(afterBook.getStatus()).isEqualTo("on_borrow");
    }
}