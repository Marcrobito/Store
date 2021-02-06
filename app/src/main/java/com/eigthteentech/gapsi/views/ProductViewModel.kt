package com.eigthteentech.gapsi.views

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.eigthteentech.gapsi.App
import com.eigthteentech.gapsi.entities.*
import com.eigthteentech.gapsi.repository.ProductsRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val repository: ProductsRepository, context: Context): ViewModel() {

    private val _response = MutableLiveData<Response<List<ProductEntity>>>()
    val response : LiveData<Response<List<ProductEntity>>> get() = _response

    private val database = Room.databaseBuilder(context, DB::class.java,"mydp")
        .allowMainThreadQueries()
        .build();

    private var currentItem:Long = 1

    init {
        _response.value = Response.NotInitialized
        val queries = database.itemDAO.getItems()
        if (queries.isNotEmpty())
            currentItem = queries.size.toLong()
    }

    fun fetchRepository(query:String){

        //database.itemDAO.insert(QueryEntity(currentItem,query))
        currentItem++
        _response.value = Response.Loading

        viewModelScope.launch {
            var products = repository.getProducts(query)
            if(products.totalResults > 0)
            _response.value = Response.Success(products.products)
            Log.d("TAG", products.toString())
        }


    }
}