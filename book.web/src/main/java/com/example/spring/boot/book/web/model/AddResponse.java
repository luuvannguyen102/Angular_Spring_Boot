/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.boot.book.web.model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class AddResponse<T> {
    private List<T> category;
    private Book book;
    private int status;
    public AddResponse() {
    }

    public List<T> getCategory() {
        return category;
    }

    public void setCategory(List<T> category) {
        this.category = category;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
