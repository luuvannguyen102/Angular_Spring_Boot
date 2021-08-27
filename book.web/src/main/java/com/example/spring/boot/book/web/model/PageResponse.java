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
public class PageResponse<T> {
    
    private int totalPage;
    private long totalElement;
    private List<T> objectPage;
    private int status;
    
    public PageResponse() {
    }
  
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

   

    public List<T> getObjectPage() {
        return objectPage;
    }

    public void setObjectPage(List<T> objectPage) {
        this.objectPage = objectPage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

  

    

    
}
