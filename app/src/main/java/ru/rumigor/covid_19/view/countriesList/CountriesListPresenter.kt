package ru.rumigor.covid_19.view.countriesList

import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter
import ru.rumigor.covid_19.data.countriesList.CovidStatsRepository
import ru.rumigor.covid_19.scheduler.Schedulers
import ru.rumigor.covid_19.view.CovidStatsViewModel

class CountriesListPresenter(
    private val covidStatsRepository : CovidStatsRepository,
    private val router: Router,
    private val schedulers: Schedulers
): MvpPresenter<CountriesListView>() {
    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            covidStatsRepository
                .getCountriesList()
                .observeOn(schedulers.background())
                .map { users -> users.map(CovidStatsViewModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showCountriesList,
                    viewState::showError
                )
    }

//    fun displayUser(user: GitHubUserViewModel) {
//        router.navigateTo(UserScreen(user.login))
//    }

    override fun onDestroy() {
        disposables.dispose()
    }

}