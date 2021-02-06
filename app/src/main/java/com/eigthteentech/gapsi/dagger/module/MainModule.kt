package com.eigthteentech.gapsi.dagger.module

import com.eigthteentech.gapsi.network.ProductsApi
import com.eigthteentech.gapsi.repository.ProductsImplementationImpl
import com.eigthteentech.gapsi.repository.ProductsRepository
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideProductsRepository(api:ProductsApi):ProductsRepository = ProductsImplementationImpl(api)
}