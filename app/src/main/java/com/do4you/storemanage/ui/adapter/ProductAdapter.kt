package com.do4you.storemanage.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.do4you.storemanage.data.model.ProductsItem
import com.do4you.storemanage.databinding.ProductItemLayoutBinding

class ProductAdapter(
    private val productList: ArrayList<ProductsItem>
) : RecyclerView.Adapter<ProductAdapter.DataViewHolder>() {
    class DataViewHolder(private val binding: ProductItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productsItem: ProductsItem) {

            binding.tvProductTitle.text = productsItem.title
            binding.tvProductPrice.text = "₹${productsItem.price}"
            binding.tvProductRating.text = "⭐ ${productsItem.rating.rate}"
            binding.tvProductCategory.text = " | ${productsItem.category}"

            Glide.with(binding.ivProductImage.context).load(productsItem.image)
                .into(binding.ivProductImage)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    )= DataViewHolder(
        ProductItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ProductAdapter.DataViewHolder, position: Int) =
        holder.bind(productList[position])

    override fun getItemCount(): Int = productList.size
    fun addData(list: List<ProductsItem>) {
        productList.addAll(list)
    }


}