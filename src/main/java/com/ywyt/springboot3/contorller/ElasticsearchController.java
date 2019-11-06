package com.ywyt.springboot3.contorller;

import com.ywyt.springboot3.entity.Book;
import com.ywyt.springboot3.repository.BookRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiejin
 * @date 2019/9/12 21:29
 */
@RestController
@RequestMapping(value = "lib")
public class ElasticsearchController {

    @Autowired
    private BookRepositroy bookRepositroy;

    @GetMapping(value = "addBook")
    public ResponseEntity<Book> addEntity(String bookId,String author) {
        Book book = new Book();
        book.setId(bookId);
        book.setTitle("springboot2.x教程");
        book.setAuthor(author);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = df.format(new Date());
        book.setReleaseDate(dateStr);

        bookRepositroy.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

}
