package ru.rumigor.covid_19.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.rumigor.covid_19.data.model.Country

interface Covid19Api {

    @GET()
    fun getCountriesList(): Single<List<Country>>
//    @GET("/code?code={code}")
//    fun getCountryByCode(@Path("code") code: String): Single<Country>
}