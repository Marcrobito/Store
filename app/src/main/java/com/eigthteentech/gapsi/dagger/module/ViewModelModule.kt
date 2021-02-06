package com.eigthteentech.gapsi.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eigthteentech.gapsi.dagger.ViewModelFactory
import com.eigthteentech.gapsi.dagger.ViewModelKey
import com.eigthteentech.gapsi.views.ProductViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    abstract fun  bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun  bindLoginViewModel(viewModel: ProductViewModel): ViewModel

}