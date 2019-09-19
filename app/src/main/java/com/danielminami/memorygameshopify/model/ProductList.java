package com.danielminami.memorygameshopify.model;

import com.danielminami.memorygameshopify.dal.Product;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This Class Models a Product List and is used in the JSON to GSON conversion
 *
 * @author Daniel Minami
 */
public class ProductList {

    @SerializedName("products")
    private List<Product> products;

    /**
     * Retrieve the list of Products
     *
     * @return list of Products
     */
    public List<Product> getProducts() {
        return products;
    }


    /**
     * Set a list of products
     *
     * @param products
     */
    /*
    public void setProducts(List<Product> products) {
        this.products = products;
    }*/
}
