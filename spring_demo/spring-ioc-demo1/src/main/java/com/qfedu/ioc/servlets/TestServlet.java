package com.qfedu.ioc.servlets;

import com.qfedu.ioc.service.ProductService;

public class TestServlet {

    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void doGet(){
        doPost();
    }

    private void doPost() {
        productService.listProducts();
    }

}
