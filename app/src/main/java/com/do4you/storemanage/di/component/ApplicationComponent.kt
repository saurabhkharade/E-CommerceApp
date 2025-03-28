package com.do4you.storemanage.di.component

import android.content.Context
import com.do4you.storemanage.StoreManageApplication
import com.do4you.storemanage.data.api.NetworkServices
import com.do4you.storemanage.data.repository.ProductRepository
import com.do4you.storemanage.di.ApplicationContext
import com.do4you.storemanage.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: StoreManageApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkServices(): NetworkServices

    fun getProductRepository(): ProductRepository

}