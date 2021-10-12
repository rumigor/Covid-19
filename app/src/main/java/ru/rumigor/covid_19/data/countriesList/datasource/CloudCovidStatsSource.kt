package ru.rumigor.covid_19.data.countriesList.datasource

import io.reactivex.Observable
import ru.rumigor.covid_19.data.api.Covid19Api
import ru.rumigor.covid_19.data.model.Country
import javax.inject.Inject

class CloudCovidStatsSource @Inject constructor(
    private val covid19Api: Covid19Api): CovidStatsSource {
    override fun getCountriesList(): Observable<List<Country>> =
        covid19Api
            .getCountriesList()
            .toObservable()
}