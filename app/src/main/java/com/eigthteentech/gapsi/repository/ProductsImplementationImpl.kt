package com.eigthteentech.gapsi.repository

import com.eigthteentech.gapsi.entities.ResponseEntity
import com.eigthteentech.gapsi.network.ProductsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsImplementationImpl  @Inject constructor(private val api:ProductsApi) : ProductsRepository {

    override suspend fun getProducts(query:String): ResponseEntity {
        return withContext(Dispatchers.IO){
            api.getProducts(query)
        }
    }
}