package com.do4you.storemanage.di.component

import com.do4you.storemanage.di.ActivityScope
import com.do4you.storemanage.di.module.ActivityModule
import com.do4you.storemanage.ui.mainapp.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}
