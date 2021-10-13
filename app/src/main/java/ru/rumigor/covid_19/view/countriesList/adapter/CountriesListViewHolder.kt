package ru.rumigor.covid_19.view.countriesList.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.rumigor.covid_19.databinding.ViewCountrieslistBinding
import ru.rumigor.covid_19.databinding.ViewCountryBinding
import ru.rumigor.covid_19.view.CovidStatsViewModel

class CountriesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val ui: ViewCountryBinding by viewBinding()

    fun bind(country: CovidStatsViewModel){
        with(ui){
             countryName.text = country.country
        }
    }
}