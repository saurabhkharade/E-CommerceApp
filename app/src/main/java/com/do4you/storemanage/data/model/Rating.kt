package com.do4you.storemanage.data.model

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count") val count: Int, @SerializedName("rate") val rate: Double
)

