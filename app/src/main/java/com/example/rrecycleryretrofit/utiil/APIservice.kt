package com.example.rrecycleryretrofit.utiil

import com.example.rrecycleryretrofit.adapter.Carta
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET
   suspend fun getCardsByName(@Url url:String): Response<Carta>
}