package com.ingubook.service;


import com.ingubook.dto.User;
import com.ingubook.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<User> findAll(){

        return userMapper.findAll();
    }

    public User findById(Long id) throws IllegalArgumentException{

        return Optional.ofNullable(userMapper.findById(id)).orElseThrow(IllegalArgumentException::new);
    }

    public User findByLoginId(String loginId) throws IllegalArgumentException{

        return Optional.ofNullable(userMapper.findByLoginId(loginId)).orElseThrow(IllegalArgumentException::new);
    }

    public void updateStatusById(Long id, String status) throws IllegalArgumentException{

        Optional.ofNullable(userMapper.findById(id))
                .ifPresentOrElse(
                        (user) -> {

                            userMapper.updateStatusById(id, status, LocalDateTime.now());
                    },
                        () -> {

                           throw new IllegalArgumentException();
                        }
                );
    }
}
