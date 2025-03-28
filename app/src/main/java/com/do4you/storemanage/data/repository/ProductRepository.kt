package com.do4you.storemanage.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.do4you.storemanage.data.api.NetworkServices
import com.do4you.storemanage.data.model.ProductsItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.exp


@Singleton
class ProductRepository @Inject constructor(
private  val networkServices: NetworkServices
) {
    fun getProductList(): Flow<List<ProductsItem>>{
        return flow {

          val  products =networkServices.getProductList()

            // Print the entire product list in logs
            Log.e("ProductRepository", "Fetched Products: $products")
            emit(products)
        }.catch { e->
            Log.e("ProductRepository", "Error fetching products: ${e.localizedMessage}", e) // Log the actual error
            emit(emptyList()) // Emit an empty list instead of crashing

        }

    }
}