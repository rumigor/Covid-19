package ru.rumigor.covid_19.view.countriesList.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.rumigor.covid_19.view.CovidStatsViewModel

object CovidDiff: DiffUtil.ItemCallback<CovidStatsViewModel>() {
    private val payload = Any()

    override fun getChangePayload(oldItem: CovidStatsViewModel, newItem: CovidStatsViewModel) = payload

    override fun areItemsTheSame(
        oldItem: CovidStatsViewModel,
        newItem: CovidStatsViewModel
    ): Boolean {
        return oldItem.country == newItem.country
    }
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: CovidStatsViewModel,
        newItem: CovidStatsViewModel
    ): Boolean {
        return oldItem == newItem
    }
}