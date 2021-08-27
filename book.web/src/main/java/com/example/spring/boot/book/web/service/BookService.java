/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.book.web.service;

import com.example.spring.boot.book.web.entities.BookEntity;
import com.example.spring.boot.book.web.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookEntity> getBooks(boolean flag) {
        return (List<BookEntity>) bookRepository.getBooks(flag);
    }

    public Page<BookEntity> getBooksByPage(boolean flag, Pageable pageable) {
        return bookRepository.getBooksByPage(flag, pageable);
    }

    public void save(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }
     public void save(List<BookEntity> bookEntity) {
        bookRepository.saveAll(bookEntity);
    }

    public BookEntity findBookById(int id) {
        return bookRepository.findBookById(id);
    }

    public List<BookEntity> findBookByNameOrSku(String name, String sku) {
        return bookRepository.findBookByNameOrSku(name, sku);
    }

//    public List<BookEntity> searchBook(String strSearch) {
////        return (List<BookEntity>) bookRepository.findByNameContainingOrAuthorContaining(strSearch, strSearch);
////        return (List<BookEntity>) bookRepository.findBookByCategoryAndPrice(strSearch, 150000);
////        return (List<BookEntity>) bookRepository.findByCategoryNameContainingAndBookDetailPriceLessThan(strSearch, 150000);
//        return (List<BookEntity>) bookRepository.findByCategory_NameContainingAndBookDetail_PriceLessThan(strSearch, 150000);
//    }
    public boolean deleteBook(BookEntity book) {
        book.setFlag(false);
        bookRepository.save(book);
        return book.isFlag();
    }
    
    public void delete (BookEntity book) {
         bookRepository.delete(book);
    }
    
    public Page<BookEntity> searchBooks (String str, boolean flag, Pageable pageable) {
        return bookRepository.searchBooks(str, flag, pageable);
    }
}
