package ru.rumigor.covid_19.data.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object Covid19ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .get()
                .header("x-rapidapi-host", "covid-19-data.p.rapidapi.com")
                .header("x-rapidapi-key", "273ef6bf0emshf2a75ae2d2a51ffp183d12jsn4d45aedf13b7")
                .build()
        )
}