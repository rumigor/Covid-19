package ru.rumigor.covid_19.di

import dagger.Subcomponent
import ru.rumigor.covid_19.data.CountriesList
import ru.rumigor.covid_19.di.modules.CountriesListModule
import ru.rumigor.covid_19.view.countriesList.CountriesListFragment

@CountriesList
@Subcomponent(modules = [CountriesListModule::class])
interface CountriesListComponent {

    fun inject(countriesListFragment: CountriesListFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): CountriesListComponent
    }
}