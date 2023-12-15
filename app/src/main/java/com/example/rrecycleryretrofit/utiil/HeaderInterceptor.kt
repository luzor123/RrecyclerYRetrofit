package com.example.rrecycleryretrofit.utiil

import okhttp3.Interceptor
import okhttp3.Response

class  HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", "0afa2e7d51mshbbfa7ff4fdef226p11a0adjsn80504aa99a13")
            .addHeader("X-RapidAPI-Host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}