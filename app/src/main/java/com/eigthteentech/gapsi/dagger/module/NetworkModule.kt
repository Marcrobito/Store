package com.eigthteentech.gapsi.dagger.module

import android.util.Log
import com.eigthteentech.gapsi.common.Constants
import com.eigthteentech.gapsi.network.ProductsApi
import dagger.Module
import dagger.Provides
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().addInterceptor(interceptor).addInterceptor{
            try{
                it.proceed(
                    it.request().newBuilder()
                        .addHeader(Constants.HEADER, Constants.API_KEY).build()
                )
            }catch (e: Exception) {
                Log.e("TAG", e.toString())
                val offlineRequest = it.request().newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
                it.proceed(offlineRequest)
            }
        }.build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): ProductsApi = retrofit.create(ProductsApi::class.java)
}