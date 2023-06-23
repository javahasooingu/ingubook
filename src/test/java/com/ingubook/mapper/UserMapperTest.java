package com.ingubook.mapper;

import com.ingubook.domain.UserDTO;
import com.ingubook.domain.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void findAll() {
    }

    @Test
    @DisplayName("findById")
    void findById() {
        long beforeSize = userMapper.findAll().size();

        UserDTO user1 = new UserDTO();

        user1.setAuth("admin");
        user1.setName("name");
        user1.setLoginId("findByIdididid");
        user1.setPassword("pwpw");
        user1.setPhoneNumber("12345678901");
        user1.setCreatedDate(LocalDateTime.now());
        user1.setStatus("available");

        userMapper.save(user1);

        Assertions.assertThat(userMapper.findById(beforeSize + 1).getLoginId()).isEqualTo("findByIdididid");
    }

    @Test
    @DisplayName("findByLoginId")
    void findByLoginId() {
        UserDTO user1 = new UserDTO();

        user1.setAuth("admin");
        user1.setName("name");
        user1.setLoginId("findByLoginIdidididid");
        user1.setPassword("pwpw");
        user1.setPhoneNumber("12345678901");
        user1.setCreatedDate(LocalDateTime.now());
        user1.setStatus("available");

        userMapper.save(user1);

        Assertions.assertThat(userMapper.findByLoginId("findByLoginIdidididid").getLoginId()).isEqualTo("findByLoginIdidididid");
    }

    @Test
    @DisplayName("findByPhoneNumber")
    void findByPhoneNumber() {
        UserDTO user1 = new UserDTO();

        user1.setAuth("admin");
        user1.setName("name");
        user1.setLoginId("findByPhoneNumber1234");
        user1.setPassword("pwpw");
        user1.setPhoneNumber("09876543210");
        user1.setCreatedDate(LocalDateTime.now());
        user1.setStatus("available");

        userMapper.save(user1);

        Assertions.assertThat(userMapper.findByPhoneNumber("09876543210").getPhoneNumber()).isEqualTo("09876543210");
    }

    @Test
    @DisplayName("save")
    void save() {long beforeSize = userMapper.findAll().size();

        UserDTO user1 = new UserDTO();

        user1.setAuth("admin");
        user1.setName("name");
        user1.setLoginId("idididid");
        user1.setPassword("pwpw");
        user1.setPhoneNumber("12345678901");
        user1.setCreatedDate(LocalDateTime.now());
        user1.setStatus("available");

        userMapper.save(user1);

        UserDTO user2 = new UserDTO();

        user2.setAuth("user");
        user2.setName("user1111111111");
        user2.setPassword("pwpw");
        user2.setLoginId("uuuuuuuuu");
        user2.setPhoneNumber("12345678901");
        user2.setCreatedDate(LocalDateTime.now());
        user2.setStatus("available");

        userMapper.save(user2);

        long afterSize = userMapper.findAll().size();

        Assertions.assertThat(beforeSize).isEqualTo(afterSize - 2);
    }

    @Test
    @DisplayName("updateStatus")
    void updateStatusById() {
        UserVO testUser = userMapper.findById(1l);

        userMapper.updateStatusById(testUser.getId(), "deleted", LocalDateTime.now());

        Assertions.assertThat(userMapper.findById(1l).getStatus()).isEqualTo("deleted");
    }
}