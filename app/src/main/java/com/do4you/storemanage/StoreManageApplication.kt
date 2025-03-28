package com.do4you.storemanage

import android.app.Application
import com.do4you.storemanage.di.component.ApplicationComponent
import com.do4you.storemanage.di.component.DaggerApplicationComponent
import com.do4you.storemanage.di.module.ApplicationModule


class StoreManageApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}