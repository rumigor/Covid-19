package ru.rumigor.covid_19.view.countriesList

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import ru.rumigor.covid_19.view.CovidStatsViewModel
import ru.rumigor.covid_19.view.ScreenView

interface CountriesListView: ScreenView {

    @SingleState
    fun showCountriesList(countriesList: List<CovidStatsViewModel>)
}