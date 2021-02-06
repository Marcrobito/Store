package com.eigthteentech.gapsi.dagger.component

import com.eigthteentech.gapsi.App
import com.eigthteentech.gapsi.dagger.module.*
import com.eigthteentech.gapsi.views.MainActivity
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    MainModule::class,
    ViewModelModule::class
])

interface AppComponent{
    fun inject(app: App)
    fun inject(activity: MainActivity)
}
