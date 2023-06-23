package com.ingubook.controller;

import com.ingubook.service.BookSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    private final BookSearchService bookSearchService;

    @GetMapping
    public String showHome() {

        return "home";
    }
}
