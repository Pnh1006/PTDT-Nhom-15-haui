package com.haui.ptda.response;

public class ProductResponse {
    private int id;
    private String name;
    private double listPrice;
    private double salePrice;
    private String detail;
    private String image;

    public ProductResponse(int id, String name, double listPrice, double salePrice, String detail, String image) {
        this.id = id;
        this.name = name;
        this.listPrice = listPrice;
        this.salePrice = salePrice;
        this.detail = detail;
        this.image = image;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
