package com.ingubook.controller;

import com.ingubook.dto.BookModifyRequest;
import com.ingubook.dto.BookRegisterRequest;
import com.ingubook.dto.BorrowHistory;
import com.ingubook.service.BookBorrowService;
import com.ingubook.service.BookService;
import com.ingubook.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/books")
@Controller
public class BookController {

    private final BookService bookService;
    private final BookBorrowService bookBorrowService;
    private final UserService userService;

    @GetMapping("")
    public String showList(Model model) {

        model.addAttribute("books", bookService.findAll());

        return "book/list";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){

        model.addAttribute("book", new BookRegisterRequest());

        return "book/register-form";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid BookRegisterRequest book) {
        try {

            bookService.register(book);

        }catch (IllegalArgumentException e) {

            return new ResponseEntity<>("입력값을 확인해주세요.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public String showDetailById(@PathVariable("id") Long id, Model model){

        model.addAttribute("book", bookService.findById(id));

        return "book/detail";
    }

    @GetMapping("/{id}/modify")
    public String showModifyFormById(@PathVariable("id") Long id, Model model) {

        model.addAttribute("book", bookService.findById(id));

        return "book/modify-form";
    }

    @PatchMapping("/{id}/modify")
    public ResponseEntity<String> modify(@Valid BookModifyRequest book) {
        try{

            bookService.modify(book);

        }catch (IllegalArgumentException e){

            return new ResponseEntity<>("입력값을 확인해주세요.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.CREATED);
    }

    @GetMapping("/{id}/borrow-history")
    public ResponseEntity<List<BorrowHistory>> getAllBorrowHistoryById(@PathVariable("id") Long id){
        try {

            bookService.findById(id);

        }catch (IllegalArgumentException e){

            return new ResponseEntity("입력값을 확인해주세요.",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(bookBorrowService.findAllHistoryByBookId(id), HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/{id}/borrow")
    public ResponseEntity<String> registerByIdAndUserLoginId(@PathVariable("id") Long id, @RequestParam("userLoginId") String userLoginId) {
        try {

            Long userId = userService.findByLoginId(userLoginId).getId();

            bookBorrowService.borrowByBookIdAndUserId(id, userId);
            bookService.updateStatusById(id, "on_borrow");
            userService.updateStatusById(userId,"on_borrow");

        }catch (IllegalArgumentException e){

            return new ResponseEntity("입력값을 확인해주세요.",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @Transactional
    @PatchMapping("/{id}/return")
    public ResponseEntity<String> modifyById(@PathVariable("id") Long id) {
        try {

            BorrowHistory history = bookBorrowService.findOneHistoryByBookIdOrderByCreatedDateDCES(id);

            bookBorrowService.returnByBorrowId(history.getId());
            bookService.updateStatusById(history.getBookId(), "available");
            userService.updateStatusById(history.getUserId(),"available");

        }catch (IllegalArgumentException e){

            return new ResponseEntity("입력값을 확인해주세요.",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("success", HttpStatus.OK);
    }
}
