package com.haui.ptda.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "list_price")
    private double listPrice;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "image")
    private String image;

    @Lob
    @Column(name = "detail")
    private String detail;

    public Product(){}

    public Product(int id, String name, double listPrice, double salePrice, String image, String detail) {
        this.id = id;
        this.name = name;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.image = image;
        this.detail = detail;
    }

    public Product(String name, double listPrice, double salePrice, String image, String detail) {
        this.name = name;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.image = image;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
