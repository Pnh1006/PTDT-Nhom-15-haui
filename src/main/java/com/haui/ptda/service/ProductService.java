package com.haui.ptda.service;

import com.haui.ptda.entity.Product;
import com.haui.ptda.repository.ProductRepository;
import com.haui.ptda.response.PageProduct;
import com.haui.ptda.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final int ADMIN_PAGE_SIZE = 7;
    private final int SHOP_PAGE_SIZE = 8;

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public PageProduct showListProduct(int page){
        Pageable pageable = PageRequest.of(page, SHOP_PAGE_SIZE);
        Page<Product> productData = productRepository.findAll(pageable);
        return new PageProduct(page, productData.getTotalPages(), productData.getContent());
    }

    public Product getProduct(int id){
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException("can not find product");
        }
    }

    public ProductResponse getProductDetail(int id){
        Product product = getProduct(id);
        return new ProductResponse(product.getId(),product.getName(), product.getListPrice(), product.getSalePrice(), product.getDetail(), product.getImage());
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
