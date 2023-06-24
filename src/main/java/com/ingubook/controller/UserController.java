package com.ingubook.controller;

import com.ingubook.dto.UserSignUpRequest;
import com.ingubook.service.BookService;
import com.ingubook.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@Controller
public class UserController {

    private final SignUpService signUpService;

    @GetMapping("")
    public String showUserPage(){
        return "user/home";
    }

    @GetMapping("/sign-up")
    public String showSignUpForm() {

        return "user/sign-up-form";
    }

    @PostMapping("/sing-up")
    public ResponseEntity<String> signUp(@Valid UserSignUpRequest user) {
        try {

            signUpService.signUp(user);

        }catch (IllegalArgumentException e){

            return new ResponseEntity<>("입력값을 확인해주세요.", HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("/return-list")
    public String showReturnBooks(){

        return "user/retrun-book-list";
    }
}
