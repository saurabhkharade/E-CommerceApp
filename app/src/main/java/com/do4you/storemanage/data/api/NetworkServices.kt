package com.do4you.storemanage.data.api

import com.do4you.storemanage.data.model.ProductsItem
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkServices {

    @GET("products")
    suspend fun getProductList(): List<ProductsItem>
}