package ru.rumigor.covid_19.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.rumigor.covid_19.di.CountriesListComponent
import ru.rumigor.covid_19.view.MainActivity

@Module(subcomponents = [CountriesListComponent::class])
interface CovidApplicationModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}