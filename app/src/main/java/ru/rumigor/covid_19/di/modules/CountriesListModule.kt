package ru.rumigor.covid_19.di.modules

import dagger.Module

@Module(includes = [CovidStatsRepositoryModule::class])
interface CountriesListModule