package com.ingubook.service;

import com.ingubook.dto.UserSignUpRequest;
import com.ingubook.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpRequest user) throws IllegalArgumentException{

        checkDuplicateLoginId(user.getLoginId());
        checkDuplicatePhoneNumber(user.getPhoneNumber());

        encodePassword(user);

        userMapper.save(user);
    }

    public void checkDuplicateLoginId(String loginId){

        Optional.ofNullable(userMapper.findByLoginId(loginId))
                .ifPresent(
                        (userVO)->{
                            throw new IllegalArgumentException();
                        }
                );
    }

    public void checkDuplicatePhoneNumber(String phoneNumber) {

        Optional.ofNullable(userMapper.findByPhoneNumber(phoneNumber))
                .ifPresent(
                        (userVO)->{
                            throw new IllegalArgumentException();
                        }
                );
    }

    private void encodePassword(UserSignUpRequest user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
    }
}
