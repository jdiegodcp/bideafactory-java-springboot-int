package com.juandiegodelacruz.bookingapi.service;

import com.juandiegodelacruz.bookingapi.model.Book;
import com.juandiegodelacruz.bookingapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private UserRepository userRepository;

    public List<Book> getAllBooks() {
        return userRepository.findAll();
    }

    public Book saveBook(Book book) {
        return userRepository.save(book);
    }
}
