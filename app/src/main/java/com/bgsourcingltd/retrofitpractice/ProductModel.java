package com.bgsourcingltd.retrofitpractice;

import java.io.Serializable;

public class ProductModel implements Serializable {

    private String productName;
    private String price;

    public ProductModel(String productName, String price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
