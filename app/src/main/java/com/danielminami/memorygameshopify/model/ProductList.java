package com.danielminami.memorygameshopify.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {

    @SerializedName("products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
