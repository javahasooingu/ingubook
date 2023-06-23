package com.ingubook.sample;

import com.ingubook.domain.BookDTO;
import com.ingubook.domain.BorrowHistoryDTO;
import com.ingubook.domain.UserDTO;
import com.ingubook.mapper.BookMapper;
import com.ingubook.mapper.BorrowHistoryMapper;
import com.ingubook.mapper.UserMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class SampleConstructor {

    private final BookMapper bookMapper;
    private final UserMapper userMapper;
    private final BorrowHistoryMapper borrowHistoryMapper;

    @Transactional
    @PostConstruct
    public void initBookSample(){
        List<BookDTO> books = new ArrayList<>();

        for(long i = 1; i <= 16; i++){
            BookDTO book = new BookDTO();

            book.setIsbn("000000000" + i);
            book.setTitle("책제목" + i);
            book.setAuthors("저자" + i);
            book.setPublisher("출판사" + i);
            book.setTranslators("번역가" + i);
            book.setPrice(i * 2000);
            book.setInfo("책정보" + i);
            book.setPublicationDate(LocalDateTime.now().minusYears(i));
            book.setThumbnail("book/thumbnail/" + i);
            book.setCreatedDate(LocalDateTime.now());
            book.setStatus("available");

            books.add(book);
        }

        books.forEach(book -> {
            bookMapper.save(book);
        });
    }

    @Transactional
    @PostConstruct
    public void initUserSample(){
        List<UserDTO> users = new ArrayList<>();

        UserDTO admin = new UserDTO();

        admin.setAuth("admin");
        admin.setName("관리자");
        admin.setLoginId("관리자아이디");
        admin.setPassword("관리자비밀번호");
        admin.setPhoneNumber("99999999999");
        admin.setCreatedDate(LocalDateTime.now());
        admin.setStatus("available");

        users.add(admin);

        for(long i = 1; i <= 5; i++){
            UserDTO user = new UserDTO();

            user.setAuth("admin");
            user.setName("이름" + i);
            user.setLoginId("로그인 아이디" + i);
            user.setPassword("비밀번호" + i);
            user.setPhoneNumber((i * 1111111111) + "");
            user.setCreatedDate(LocalDateTime.now());
            user.setStatus("available");

            users.add(user);
        }

        users.forEach(user -> {
            userMapper.save(user);
        });
    }

    @Transactional
    @PostConstruct
    public void initBorrowHistorySample(){
        List<BorrowHistoryDTO> borrowHistorys = new ArrayList<>();

        for(long i = 1; i <= 16; i++){
            BorrowHistoryDTO history = new BorrowHistoryDTO();
            LocalDateTime nowTime = LocalDateTime.now();

            history.setBookId((long)((Math.random() * 16) + 1));
            history.setUserId((long)((Math.random() * 5) + 2));
            history.setBorrowDate(nowTime);
            history.setDueDate(LocalDateTime.now().plusDays(7));
            history.setCreatedDate(nowTime);
            history.setStatus("on_borrow");

            borrowHistorys.add(history);
        }

        borrowHistorys.forEach(history -> {
            borrowHistoryMapper.save(history);
        });
    }



}
