package ru.rumigor.covid_19.data.countriesList

import io.reactivex.Observable
import ru.rumigor.covid_19.data.countriesList.datasource.CacheCovidStatsSource
import ru.rumigor.covid_19.data.countriesList.datasource.CloudCovidStatsSource
import ru.rumigor.covid_19.data.countriesList.datasource.CovidStatsSource
import ru.rumigor.covid_19.data.model.Country
import javax.inject.Inject

class CovidStatsRepositoryImpl @Inject constructor(
    private val cloud: CovidStatsSource,
    private val cache: CacheCovidStatsSource
) : CovidStatsRepository {
    override fun getCountriesList(): Observable<List<Country>> =
        Observable.merge(
            cache.getCountriesList(),
            cloud.getCountriesList().flatMapSingle(cache::retain)
        )


}