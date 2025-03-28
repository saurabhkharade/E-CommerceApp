package com.do4you.storemanage.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class ProductsItem(
    @SerializedName("id") val id: Int,
    @SerializedName("category") val category: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("price") val price: Double,
    @SerializedName("rating") val rating: Rating,
    @SerializedName("title") val title: String
)