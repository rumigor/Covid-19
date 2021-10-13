package ru.rumigor.covid_19.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.rumigor.covid_19.CovidApp
import ru.rumigor.covid_19.di.modules.*
import ru.rumigor.covid_19.scheduler.Schedulers


@Component(modules = [AndroidInjectionModule::class, CovidApplicationModule::class, CountriesListStorageModule::class,
CovidApiModule::class, CountriesListModule::class, CovidStatsRepositoryModule::class])
interface CovidApplicationComponent : AndroidInjector<CovidApp> {

    fun countriesListComponent(): CountriesListComponent.Builder

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): CovidApplicationComponent
    }

}