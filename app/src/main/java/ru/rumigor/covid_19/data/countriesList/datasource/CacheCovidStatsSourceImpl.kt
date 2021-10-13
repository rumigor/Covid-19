package ru.rumigor.covid_19.data.countriesList.datasource

import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.covid_19.data.InMemory
import ru.rumigor.covid_19.data.model.Country
import ru.rumigor.covid_19.data.storage.CovidStatsStorage
import javax.inject.Inject

class CacheCovidStatsSourceImpl @Inject constructor(
    @InMemory private val covidStatsStorage: CovidStatsStorage): CacheCovidStatsSource {
    override fun retain(countriesList: List<Country>): Single<List<Country>> =
        covidStatsStorage
            .covidStatsDao()
            .retain(countriesList)
            .andThen(getCountriesList().firstOrError())


    override fun getCountriesList(): Observable<List<Country>> =
        covidStatsStorage.covidStatsDao().fetchCountriesList()

}