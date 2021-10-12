package ru.rumigor.covid_19.data.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object Covid19ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic("USER_NAME", "USER_PASSWORD"))
                .build()
        )
}