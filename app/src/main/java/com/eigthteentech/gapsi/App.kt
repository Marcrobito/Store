package com.eigthteentech.gapsi

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.eigthteentech.gapsi.dagger.component.AppComponent
import com.eigthteentech.gapsi.dagger.component.DaggerAppComponent
import com.eigthteentech.gapsi.dagger.module.AppModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class App: Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>
    lateinit var appComponent:AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        getComponent().inject(this)

    }

    fun getComponent() = appComponent

    override fun activityInjector() =  dispatchingActivityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentInjector

}