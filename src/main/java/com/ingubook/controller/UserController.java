package com.ingubook.controller;

import com.ingubook.service.BookSearchService;
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

    private final BookSearchService bookSearchService;

    @GetMapping("")
    public String showUserPage(){
        return "user/home";
    }

    @GetMapping("/sign-up")
    public String showSignUpForm() {

        return "user/sign-up-form";
    }

    @PostMapping("/sing-up")
    public ResponseEntity<String> signUp() {

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @PostMapping("/id-check")
    public ResponseEntity<String> checkDuplicateId() {
        log.info("ID 중복확인");

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @PostMapping("/phone-check")
    public ResponseEntity<String> checkDuplicatePhoneNumber() {
        log.info("PHONE 중복확인");

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("/return-list")
    public String showReturnBooks(){

        return "user/retrun-book-list";
    }
}
