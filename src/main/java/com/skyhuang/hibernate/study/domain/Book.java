package com.skyhuang.hibernate.study.domain;

/**
 * Created by dahoufang the one on 2017/12/27.
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Double price;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author
                + ", price=" + price + "]";
    }
}
