package com.ingubook.sample;

import com.ingubook.dto.BookRegisterRequest;
import com.ingubook.dto.BorrowHistoryRegister;
import com.ingubook.dto.UserSignUpRequest;
import com.ingubook.mapper.BookMapper;
import com.ingubook.mapper.BorrowHistoryMapper;
import com.ingubook.mapper.UserMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        List<BookRegisterRequest> books = new ArrayList<>();

        for(long i = 1; i <= 16; i++){
            BookRegisterRequest book = BookRegisterRequest.builder()
                    .isbn("000000000" + i)
                    .title("책제목" + i)
                    .authors("저자" + i)
                    .publisher("출판사" + i)
                    .translators("번역가" + i)
                    .price(i * 2000)
                    .info("책정보" + i)
                    .publicationDate(LocalDateTime.now().minusYears(i))
                    .build();

            books.add(book);
        }

        books.forEach(book -> {
            bookMapper.save(book);
        });
    }

    @Transactional
    @PostConstruct
    public void initUserSample(){
        List<UserSignUpRequest> users = new ArrayList<>();

        for(long i = 1; i <= 5; i++){
            UserSignUpRequest user = UserSignUpRequest.builder()
                    .name("이름" + i)
                    .loginId("로그인 아이디" + i)
                    .password("비밀번호" + i)
                    .phoneNumber((i * 1111111111) + "")
                    .build();

            users.add(user);
        }

        users.forEach(user -> {
            userMapper.save(user);
        });
    }

    @Transactional
    @PostConstruct
    public void initBorrowHistorySample() {
        List<BorrowHistoryRegister> borrowHistorys = new ArrayList<>();

        for (long i = 1; i <= 16; i++) {
            BorrowHistoryRegister history = new BorrowHistoryRegister();
            LocalDateTime nowTime = LocalDateTime.now();

            history.setBookId((long) ((Math.random() * 16) + 1));
            history.setUserId((long) ((Math.random() * 5) + 2));
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
