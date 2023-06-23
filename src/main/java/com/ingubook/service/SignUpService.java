package com.ingubook.service;

import com.ingubook.domain.UserDTO;
import com.ingubook.domain.UserVO;
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

    public Boolean checkDuplicateLoginId(String loginId){

        return Optional.ofNullable(userMapper.findByLoginId(loginId)).isPresent();
    }

    public Boolean checkDuplicatePhoneNumber(String phoneNumber){

        return Optional.ofNullable(userMapper.findByLoginId(phoneNumber)).isPresent();
    }

    public void signUp(UserDTO user){

        encodePassword(user);

        userMapper.save(user);
    }

    private void encodePassword(UserDTO user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);
    }
}
