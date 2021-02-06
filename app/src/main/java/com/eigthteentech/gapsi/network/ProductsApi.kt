package com.eigthteentech.gapsi.network

import com.eigthteentech.gapsi.entities.ResponseEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {

    @GET("search")
    suspend fun getProducts(@Query("query") product:String):ResponseEntity
}