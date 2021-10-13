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
                .header("x-rapidapi-host", "covid-193.p.rapidapi.com")
                .header("x-rapidapi-key", "2d55321602msh33c8d91c041d686p1bd305jsn6b6ee598e59a")
                .build()
        )
}