package ru.rumigor.covid_19.view.countriesList.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.rumigor.covid_19.R
import ru.rumigor.covid_19.view.CovidStatsViewModel

class CountriesListAdapter(): ListAdapter<CovidStatsViewModel, CountriesListViewHolder>(CovidDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesListViewHolder =
        CountriesListViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_countrieslist, parent, false)

    )

    override fun onBindViewHolder(holder: CountriesListViewHolder, position: Int) =
        holder.bind(getItem(position))

}