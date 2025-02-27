package com.danielminami.memorygame.repository;

import com.danielminami.memorygame.model.ProductList;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * This Interface is the Retrofit Client to import the list of Products from the EndPoint
 *
 * Call Object makes the call assincronous
 *
 * @author Daniel Minami
 *
 */
public interface ProductClient {

    @GET("/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ProductList> getProductList();
}
