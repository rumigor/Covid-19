package ru.rumigor.covid_19.data.countriesList

import io.reactivex.Observable
import ru.rumigor.covid_19.data.model.Country

interface CovidCountriesListRepository {

    fun getCountriesList(): Observable<List<Country>>
}