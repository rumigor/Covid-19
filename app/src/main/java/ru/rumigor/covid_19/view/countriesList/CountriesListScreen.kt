package ru.rumigor.covid_19.view.countriesList

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object CountriesListScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        CountriesListFragment.newInstance()
}