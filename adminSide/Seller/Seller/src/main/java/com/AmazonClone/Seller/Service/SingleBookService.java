package com.AmazonClone.Seller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AmazonClone.Seller.Model.SingleBook;
import com.AmazonClone.Seller.Repository.SingleBookRepo;


@Service
public class SingleBookService {

    @Autowired
    private SingleBookRepo bookRepo;

    public List<SingleBook> getAllBooks() {
        return bookRepo.findAll();
    }

    public SingleBook getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public SingleBook createBook(SingleBook book) {
        return bookRepo.save(book);
    }

    public SingleBook updateBook(Long id, SingleBook book) {
        if (bookRepo.existsById(id)) {
            book.setId(id);
            return bookRepo.save(book);
        }
        return null;
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
