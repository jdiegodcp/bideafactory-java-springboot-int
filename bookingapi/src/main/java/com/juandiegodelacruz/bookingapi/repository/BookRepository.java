package com.juandiegodelacruz.bookingapi.repository;
import com.juandiegodelacruz.bookingapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}