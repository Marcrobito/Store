package com.eigthteentech.gapsi.repository

import com.eigthteentech.gapsi.entities.ResponseEntity

interface ProductsRepository {
    suspend fun getProducts(query:String):ResponseEntity

}