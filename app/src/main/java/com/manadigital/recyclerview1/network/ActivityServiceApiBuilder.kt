package com.manadigital.recyclerview1.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ActivityServiceApiBuilder {

    private val BASE_URL = "https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/"


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): FlightService {
        return retrofit.create(FlightService::class.java)
    }
}