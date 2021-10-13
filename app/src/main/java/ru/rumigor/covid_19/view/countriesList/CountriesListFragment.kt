package ru.rumigor.covid_19.view.countriesList

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import ru.rumigor.covid_19.CovidApp
import ru.rumigor.covid_19.R
import ru.rumigor.covid_19.arguments
import ru.rumigor.covid_19.data.countriesList.CovidStatsRepository
import ru.rumigor.covid_19.databinding.ViewCountrieslistBinding
import ru.rumigor.covid_19.di.CountriesListComponent
import ru.rumigor.covid_19.scheduler.Schedulers
import ru.rumigor.covid_19.view.CovidStatsViewModel
import ru.rumigor.covid_19.view.countriesList.adapter.CountriesListAdapter
import javax.inject.Inject

class CountriesListFragment:MvpAppCompatFragment(R.layout.view_countrieslist), CountriesListView {

    companion object {
        fun newInstance(): Fragment =
            CountriesListFragment().arguments()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var covidStatsRepository: CovidStatsRepository

    private val ui: ViewCountrieslistBinding by viewBinding()
    private val countriesListAdapter = CountriesListAdapter()

    private var countriesListComponent: CountriesListComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        countriesListComponent =
            (requireActivity().application as? CovidApp)
                ?.covidApplicationComponent
                ?.countriesListComponent()
                ?.build()
                ?.also { it.inject(this) }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui.countriesList.adapter = countriesListAdapter
    }

    override fun showCountriesList(countriesList: List<CovidStatsViewModel>) {
       countriesListAdapter.submitList(countriesList)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        countriesListComponent = null
    }


}