package com.lince23.f1info.core.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ApiClient {
    private val BASE_URL = "https://api.openf1.org/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(typeClass: Class<T>):T{
        return retrofit.create(typeClass)
    }
}