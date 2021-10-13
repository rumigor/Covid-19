package ru.rumigor.covid_19.data.countriesList.datasource

import io.reactivex.Observable
import ru.rumigor.covid_19.data.model.Country

interface CovidStatsSource {
    fun getCountriesList(): Observable<List<Country>>
}