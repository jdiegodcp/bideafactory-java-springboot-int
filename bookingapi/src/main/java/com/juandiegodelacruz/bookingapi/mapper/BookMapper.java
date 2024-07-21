package com.juandiegodelacruz.bookingapi.mapper;


import com.juandiegodelacruz.bookingapi.dto.BookDto;
import com.juandiegodelacruz.bookingapi.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

// It's used a mapper to allow the interchange between DTO and moodel, in this case I just decired to use from bookDto to book.
@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    @Mapping(target = "idBooked", ignore = true)
    Book bookDTOToBook(BookDto bookDto);
}