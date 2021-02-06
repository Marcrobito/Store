package com.eigthteentech.gapsi.dagger.module

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [
    //ViewsModule.ProductListFragmentSubcomponent::class,
])

abstract class ViewsModule {
/*
    @Subcomponent
    interface ProductListFragmentSubcomponent : AndroidInjector<ProductListFragment> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<ProductListFragment>()
    }

    @Binds
    @IntoMap
    @FragmentKey(ProductListFragment::class)
    abstract fun bindLoginFragmentInjectorFactory(builder: ProductListFragmentSubcomponent.Builder): AndroidInjector.Factory<out Fragment>*/

}