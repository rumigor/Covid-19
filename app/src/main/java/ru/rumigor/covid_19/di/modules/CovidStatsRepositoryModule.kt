package ru.rumigor.covid_19.di.modules

import dagger.Binds
import dagger.Module
import ru.rumigor.covid_19.data.countriesList.CovidStatsRepository
import ru.rumigor.covid_19.data.countriesList.CovidStatsRepositoryImpl
import ru.rumigor.covid_19.data.countriesList.datasource.CacheCovidStatsSource
import ru.rumigor.covid_19.data.countriesList.datasource.CacheCovidStatsSourceImpl
import ru.rumigor.covid_19.data.countriesList.datasource.CloudCovidStatsSource
import ru.rumigor.covid_19.data.countriesList.datasource.CovidStatsSource

@Module(includes = [CountriesListStorageModule::class, CovidApiModule::class])
interface CovidStatsRepositoryModule {
    @Binds
    fun bindCovidStatsRepository(repository: CovidStatsRepositoryImpl): CovidStatsRepository

    @Binds
    fun bindCovidStatsSource(covidStatsSource: CloudCovidStatsSource): CovidStatsSource

    @Binds
    fun bindCacheCovidStatsSource(covidStatsSource: CacheCovidStatsSourceImpl): CacheCovidStatsSource
}