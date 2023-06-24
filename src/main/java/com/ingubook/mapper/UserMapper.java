package com.ingubook.mapper;

import com.ingubook.dto.BorrowHistoryModify;
import com.ingubook.dto.UserSignUpRequest;
import com.ingubook.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {

    void save(UserSignUpRequest user);
    List<User> findAll();
    User findById(@Param("id") Long id);
    User findByLoginId(@Param("loginId") String loginId);
    User findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    void updateStatusById(@Param("id") Long id, @Param("status") String Status, @Param("modifiedDate") LocalDateTime modifiedDate);
}
