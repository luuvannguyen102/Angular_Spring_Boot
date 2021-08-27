/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.book.web.repository;

import com.example.spring.boot.book.web.entities.CategoryEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Admin
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
    
    @Query(value = "Select c from CategoryEntity c")
    List<CategoryEntity> getCategorys();
}
