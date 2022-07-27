package com.darasoylu.retrofitexm.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Test-1", "123")
            .addHeader("Test-2", "456")
            .addHeader("Test-3", "789")
            .build()
        return chain.proceed(request)
    }
}