package com.ingubook.service;


import com.ingubook.domain.BookVO;
import com.ingubook.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSearchService {

    private final BookMapper bookMapper;

    public List<BookVO> findAll(){

        return bookMapper.findAll();
    }
}
