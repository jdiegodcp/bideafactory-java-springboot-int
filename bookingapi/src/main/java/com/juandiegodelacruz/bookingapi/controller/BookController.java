package com.juandiegodelacruz.bookingapi.controller;

import com.juandiegodelacruz.bookingapi.dto.BookDto;
import com.juandiegodelacruz.bookingapi.dto.BookResponse;
import com.juandiegodelacruz.bookingapi.dto.ErrorResponse;
import com.juandiegodelacruz.bookingapi.mapper.BookMapper;
import com.juandiegodelacruz.bookingapi.model.Book;
import com.juandiegodelacruz.bookingapi.model.RequestDiscount;
import com.juandiegodelacruz.bookingapi.model.ResponseDiscount;
import com.juandiegodelacruz.bookingapi.service.ApiService;
import com.juandiegodelacruz.bookingapi.service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Validated
public class BookController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private BookService bookService;

    @Value("${external.api.url}")
    private String apiUrl;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/bideafactory/books")
    public List<Book> getAllUsers() {
        logger.info("List all booking done and saved in the database");
        return bookService.getAllBooks();
    }

    @PostMapping("/bideafactory/book")
    public ResponseEntity<?> book(@Valid @RequestBody BookDto bookDto) {
        logger.info("At first the validation of the fields was done using the BookDTO rules and the messages captures using CustomExceptionHandler");
        if(bookDto.getDiscountCode()!=null ) {
            if(!validateRequest(bookDto)) {
                logger.info("API to Validate dictated that the code does not have discount");
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setError("Conflict");
                errorResponse.setStatusCode(400);
                errorResponse.setMessage("invalid discount");
                return ResponseEntity.ok(errorResponse);
            }
            logger.info("API to Validate dictated that the code does have discount");
        }
        logger.info("Either way having or not a discountCode the book it's sent to be saved");
        bookService.saveBook(bookMapper.bookDTOToBook(bookDto));
        logger.info("Booking is already done");
        logger.info("Preparing for returning the message with it's respective code");
        BookResponse bookResponse = new BookResponse();
        bookResponse.setCode(200);
        bookResponse.setMessage("Book Accepted");
        return ResponseEntity.ok(bookResponse);

    }

    private Boolean validateRequest(BookDto book){
        logger.info("Begin request's validation");
        RequestDiscount requestDiscount = new RequestDiscount();
        requestDiscount.setUserId(book.getId());
        requestDiscount.setHouseId(book.getHouseId());
        requestDiscount.setDiscountCode(book.getDiscountCode());
        logger.info("After getting the elements necessary to use de external API it's sent to the service that will return the response");
        return apiService.validateApiData(apiUrl,requestDiscount, ResponseDiscount.class).isStatus();
    }
}
