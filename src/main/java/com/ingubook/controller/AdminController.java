package com.ingubook.controller;

import com.ingubook.service.BookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class AdminController {

    private final BookSearchService bookSearchService;

    @GetMapping("register")
    public String showmRegisterForm(){

        return "book/register-form";
    }

    @PostMapping("register")
    public ResponseEntity<String> register(Model model) {

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("list")
    public String showList(Model model) {

        model.addAttribute("books", bookSearchService.findAll());

        return "book/list";
    }

    @GetMapping("/{id}")
    public String showDetail(){

        return "book/detail";
    }

    @PatchMapping("/{id}/modify")
    public ResponseEntity<String> modify(@PathVariable("id") Long id, Model model) {

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<String> borrowOne(@PathVariable("id") Long id, Model model) {

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @PatchMapping("/{id}/return")
    public ResponseEntity<String> returnOne(@PathVariable("id") Long id, Model model) {

        return new ResponseEntity("success", HttpStatus.OK);
    }

    @GetMapping("/{id}/history")
    public String showBorrowHistory(@PathVariable("id") Long id, Model model) {

        return "book/borrow-history";
    }

}
