package com.ingubook.service;


import com.ingubook.dto.BookModifyRequest;
import com.ingubook.dto.BookRegisterRequest;
import com.ingubook.dto.Book;
import com.ingubook.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    public List<Book> findAll(){

        return bookMapper.findAll();
    }

    public Book findById(Long id){

        return Optional.ofNullable(bookMapper.findById(id)).orElseThrow(IllegalArgumentException::new);
    }

    public void register(BookRegisterRequest book) throws IllegalArgumentException {

        checkDuplicateIsbn(book.getIsbn());

        bookMapper.save(book);
    }

    public void modify(BookModifyRequest modifiedBook) throws IllegalArgumentException{
        Book originalBook = findById(modifiedBook.getId());

        checkDuplicateIsbn(modifiedBook.getIsbn(), originalBook.getIsbn());

        bookMapper.update(modifiedBook);
    }

    private void checkDuplicateIsbn(String modifiedBookIsbn, String originalBookIsbn) {

        if(!originalBookIsbn.equals(modifiedBookIsbn)){

            checkDuplicateIsbn(modifiedBookIsbn);
        }
    }

    public void checkDuplicateIsbn(String isbn){

        Optional.ofNullable(bookMapper.findByIsbn(isbn))
                .ifPresent(
                        (bookVO)->{
                            throw new IllegalArgumentException();
                        }
                );
    }

    public void updateStatusById(Long id, String status){

        Optional.ofNullable(bookMapper.findById(id))
                .ifPresentOrElse(
                        (book) -> {

                            bookMapper.updateStatusById(id, status, LocalDateTime.now());
                        },
                        () -> {

                            throw new IllegalArgumentException();
                        }
                );
    }
}
