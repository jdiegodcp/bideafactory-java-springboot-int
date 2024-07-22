package com.juandiegodelacruz.bookingapi;

import com.juandiegodelacruz.bookingapi.model.Book;
import com.juandiegodelacruz.bookingapi.repository.BookRepository;
import com.juandiegodelacruz.bookingapi.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testSaveBook() {
        Book book = new Book();
        book.setName("John Doe");

        when(bookRepository.save(any(Book.class))).thenReturn(book);

        Book savedUser = bookRepository.save(book);

        assertThat(savedUser.getName()).isEqualTo("John Doe");
    }

    @Test
    public void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setId("111");
        book.setName("John Doe");
        books.add(book);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> foundBooks = bookService.getAllBooks();

        assertThat(foundBooks).isNotEmpty();
        assertThat(foundBooks.get(0).getName()).isEqualTo("John Doe");
    }
}