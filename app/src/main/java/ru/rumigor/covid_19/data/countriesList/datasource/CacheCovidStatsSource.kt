package ru.rumigor.covid_19.data.countriesList.datasource

import io.reactivex.Single
import ru.rumigor.covid_19.data.model.Country

interface CacheCovidStatsSource : CovidStatsSource{
    fun retain(countriesList: List<Country>): Single<List<Country>>

}