package ru.rumigor.covid_19.data.countriesList

import dagger.Provides
import io.reactivex.Observable
import ru.rumigor.covid_19.data.model.Country


interface CovidStatsRepository {
        fun getCountriesList(): Observable<List<Country>>
}