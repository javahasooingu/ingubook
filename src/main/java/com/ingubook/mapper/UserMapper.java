package com.ingubook.mapper;

import com.ingubook.domain.UserDTO;
import com.ingubook.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface UserMapper {

    void save(UserDTO userDto);
    List<UserVO> findAll();
    UserVO findById(@Param("id") Long id);
    UserVO findByLoginId(@Param("loginId") String loginId);
    UserVO findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    void updateStatusById(@Param("id") Long id, @Param("status") String Status, @Param("modifiedDate") LocalDateTime modifiedDate);
}
