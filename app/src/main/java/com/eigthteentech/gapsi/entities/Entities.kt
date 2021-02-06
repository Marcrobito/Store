package com.eigthteentech.gapsi.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseEntity(@SerializedName("totalResults") @Expose val totalResults:Int,
                          @SerializedName("page") @Expose val currentPage:Int,
                          @SerializedName("items") @Expose val products:List<ProductEntity>)

data class ProductEntity(@SerializedName("id") @Expose val id:String,
                         @SerializedName("rating") @Expose val rating:Float,
                         @SerializedName("price") @Expose val price:Double,
                         @SerializedName("image") @Expose val image:String,
                         @SerializedName("title") @Expose val title:String)