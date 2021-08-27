/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.book.web.repository;

import com.example.spring.boot.book.web.entities.BookEntity;
import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface BookRepository
        extends CrudRepository<BookEntity, Integer> {
    
    @Query(value = "Select b from BookEntity b where"
            + " b.flag = ?1")
   List <BookEntity> getBooks (boolean flag);
   
   @Query(value = "Select b from BookEntity b where"
           + " b.flag = ?1"
           + " order by b.createDate "
         )
   Page <BookEntity> getBooksByPage (boolean flag, Pageable pageable) ;
   
   @Query(value = "Select b from BookEntity b where "
           + " b.name = ?1"
           + " or b.sku = ?2")
   List<BookEntity> findBookByNameOrSku(String name, String sku);
   
   @Query(value = "Select b from BookEntity b where"
           + " b.id = ?1")
   BookEntity findBookById(int id);
   
   @Query(value = "Select b from BookEntity b where"
           + " b.name like ?1% or"
           + " b.author like ?1% or"
           + " b.sku like ?1% and"
           + " b.flag = ?2")
   Page <BookEntity> searchBooks(String str, boolean flag,Pageable pageable);
//    List<BookEntity>
//            findByNameContainingOrAuthorContaining(String name, String author);
//
//    List<BookEntity> findByAuthorContainingOrderByAuthorDesc(String strSearch);

//    @Query("Select b from BookEntity b where "
//            + "b.category.name Like ?1 and "
//            + "b.bookDetail.price < ?2 "
//            + "order by b.name desc")
//    List<BookEntity> findBookByCategoryAndPrice(String name, double price);
//
//    @Query(value = "Select * from book b"
//            + " join book_detail bd on b.book_detail_id = bd.id"
//            + " join category c on c.id = b.category_id"
//            + " where c.name like ?1"
//            + " and bd.price < ?2"
//            + " order by b.name desc", nativeQuery = true)
//    List<BookEntity> findBookByCategoryAndPriceNative(String name, double price);

//    List<BookEntity> findByCategoryNameContainingAndBookDetailPriceLessThan(String name, double price);
//    List<BookEntity> findByCategory_NameContainingAndBookDetail_PriceLessThan(String name, double price);
}
