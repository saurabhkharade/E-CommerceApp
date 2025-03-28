package com.do4you.storemanage.di.module

import android.content.Context
import com.do4you.storemanage.StoreManageApplication
import com.do4you.storemanage.data.api.NetworkServices
import com.do4you.storemanage.di.ApplicationContext
import com.do4you.storemanage.di.BaseUrl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class ApplicationModule(private val application: StoreManageApplication) {

    @ApplicationContext
    @Provides
    fun providesContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun providesBaseUrls(): String = "https://fakestoreapi.com/"


    @Provides
    @Singleton
    fun providesGsonConvertorFactory(): GsonConverterFactory = GsonConverterFactory.create()


    @Provides
    @Singleton
    fun providesNetworkServices(
        @BaseUrl baseUrl: String, gsonConverterFactory: GsonConverterFactory

    ): NetworkServices {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gsonConverterFactory).build()
            .create(NetworkServices::class.java)
    }


}
