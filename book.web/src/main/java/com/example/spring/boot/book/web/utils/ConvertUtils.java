/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.book.web.utils;

import com.example.spring.boot.book.web.entities.BookEntity;
import com.example.spring.boot.book.web.entities.CategoryEntity;
import com.example.spring.boot.book.web.model.Book;
import com.example.spring.boot.book.web.model.Category;
import com.example.spring.boot.book.web.model.PageResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author ASUS
 */
public class ConvertUtils {

    public static Book convertBookFromBookEntity(BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setName(bookEntity.getName());
        book.setAuthor(bookEntity.getAuthor());
        book.setDescription(bookEntity.getDescription());
        book.setIsbn(bookEntity.getIsbn());
        book.setNumberOfPage(bookEntity.getNumberOfPage());
        book.setPrice(bookEntity.getPrice());
        book.setPublishDate(bookEntity.getPublishDate());
        book.setCreateDate(bookEntity.getCreateDate());
        book.setQuantity(bookEntity.getQuantity());
        book.setFlag(bookEntity.isFlag());
        book.setStatus(bookEntity.getStatus());
        book.setSku(bookEntity.getSku());

//        BookDetail bookDetail = new BookDetail();
//        bookDetail.setDescription(bookEntity.getBookDetail().getDescription());
//        bookDetail.setId(bookEntity.getBookDetail().getId());
//        bookDetail.setIsbn(bookEntity.getBookDetail().getIsbn());
//        bookDetail.setNumberOfPage(bookEntity.getBookDetail().getNumberOfPage());
//        bookDetail.setPrice(bookEntity.getBookDetail().getPrice());
//        bookDetail.setPublishDate(bookEntity.getBookDetail().getPublishDate());
//
        Category category = new Category();
        category.setId(bookEntity.getCategory().getId());
        category.setName(bookEntity.getCategory().getName());
//        List<Book> books = new ArrayList<>();
//        books.add(book);
//        category.setBooks(books);

//        book.setBookDetail(bookDetail);
        book.setCategory(category);

        return book;
    }

    public static BookEntity converBookEntityFromBook(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(book.getId());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setCreateDate(book.getCreateDate());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setFlag(book.isFlag());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setNumberOfPage(book.getNumberOfPage());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setPublishDate(book.getPublishDate());
        bookEntity.setSku(book.getSku());
        bookEntity.setStatus(book.getStatus());
        bookEntity.setName(book.getName());
        bookEntity.setQuantity(book.getQuantity());
        
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setId(book.getCategory().getId());
//        categoryEntity.setName(book.getCategory().getName());
//        bookEntity.setCategory(categoryEntity);
        return bookEntity;
    }
    
    

    public static List<Book> convertListBookFromListBookEntity(List<BookEntity> book) {
        List<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : book) {
            books.add(
                    ConvertUtils.convertBookFromBookEntity(bookEntity));
        }
        return books;
    }

//    public static Page<Book> convertPageBookFromListBookEntity(Page<BookEntity> book) {
//        Page<Book> books ;
//        for (BookEntity bookEntity : book) {
//            books.add(
//                    ConvertUtils.convertBookFromBookEntity(bookEntity));
//        }
//        return books;
//    }
    public static PageResponse<Book> convertPageBookFromListPageBookEntity(Page<BookEntity> bookEntitys) {
        List<BookEntity> bookEntitys1 = new ArrayList<>();
        for (BookEntity b : bookEntitys) {
            bookEntitys1.add(b);
        }
        List<Book> books = convertListBookFromListBookEntity(bookEntitys1);
        PageResponse<Book> pageResponse = new PageResponse<>();
        pageResponse.setObjectPage(books);
        pageResponse.setTotalPage(bookEntitys.getTotalPages());
        pageResponse.setTotalElement(bookEntitys.getTotalElements());
        return pageResponse;
    }

    public static Category convertCategoryFromCategoryEntity(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }

    public static List<Category> convertListCategoryFromListCategoryEntity(List<CategoryEntity> categorys) {
        List<Category> list = new ArrayList<>();
        for (CategoryEntity categoryEntity : categorys) {
            list.add(convertCategoryFromCategoryEntity(categoryEntity));
        }
        return list;
    }
}
