package ru.rumigor.covid_19.di.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.rumigor.covid_19.data.api.Covid19Api
import ru.rumigor.covid_19.data.api.Covid19ApiInterceptor
import javax.inject.Named

@Module
class CovidApiModule {
    @Named("covid_api")
    @Provides
    fun provideBaseUrlProd(): String = "https://covid-193.p.rapidapi.com/"

    @Reusable
    @Provides
    fun provideCovidApi (@Named("covid_api") baseUrl: String): Covid19Api =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(Covid19ApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
            ).build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Covid19Api::class.java)
}