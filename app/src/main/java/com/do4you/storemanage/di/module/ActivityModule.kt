package com.do4you.storemanage.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.do4you.storemanage.data.repository.ProductRepository
import com.do4you.storemanage.di.ActivityContext
import com.do4you.storemanage.ui.adapter.ProductAdapter
import com.do4you.storemanage.ui.base.ViewModelProviderFactory
import com.do4you.storemanage.ui.viewmodel.ProductListViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {


    @ActivityContext
    @Provides
    fun providesContext(): Context {
        return activity
    }

    @Provides
    fun providesNewsListViewModel(productRepository: ProductRepository): ProductListViewModel {
        return ViewModelProvider(activity, ViewModelProviderFactory(ProductListViewModel::class) {
            ProductListViewModel(productRepository)
        })[ProductListViewModel::class.java]
    }


@Provides
fun providesTopHeadlinesAdapter()= ProductAdapter(ArrayList())

}