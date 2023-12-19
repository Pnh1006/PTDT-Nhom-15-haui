package com.haui.ptda.response;


import com.haui.ptda.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class PageProduct{
    int currentPage;
    int totalPage;
    List<Product> productData;
    List<PageElement> pageList = new ArrayList<>();

    public PageProduct(int currentPage, int totalPage, List<Product> productData) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.productData = productData;
        generatePageList();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Product> getProductData() {
        return productData;
    }

    public void setProductData(List<Product> productData) {
        this.productData = productData;
    }

    public List<PageElement> getPageList() {
        return pageList;
    }

    public void setPageList(List<PageElement> pageList) {
        this.pageList = pageList;
    }

    private void generatePageList(){
        for (int i = 0; i < totalPage; i++){
            if (i == currentPage){
                pageList.add(new PageElement(i, true));
            } else {
                pageList.add(new PageElement(i, false));
            }
        }
    }
}
