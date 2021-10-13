package ru.rumigor.covid_19


import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.plugins.RxJavaPlugins
import ru.rumigor.covid_19.di.CovidApplicationComponent

import ru.rumigor.covid_19.di.DaggerCovidApplicationComponent
import ru.rumigor.covid_19.scheduler.DefaultSchedulers


class CovidApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<CovidApp> =
        covidApplicationComponent

    val covidApplicationComponent: CovidApplicationComponent by lazy {
        DaggerCovidApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {  }
    }

}



