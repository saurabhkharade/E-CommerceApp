package com.do4you.storemanage.ui.base

import android.hardware.camera2.DngCreator
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Singleton
import kotlin.jvm.Throws
import kotlin.reflect.KClass


@Singleton
class ViewModelProviderFactory <T: ViewModel>(
private  val kClass: KClass<T>, private val creator:()-> T
): ViewModelProvider.NewInstanceFactory(){

    @Suppress("")
    @Throws(IllegalArgumentException::class)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(kClass.java)) return creator() as T
        throw IllegalArgumentException("Unknown class name")
    }

}