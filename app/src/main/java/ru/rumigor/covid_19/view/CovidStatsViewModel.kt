package ru.rumigor.covid_19.view

import ru.rumigor.covid_19.data.model.Country

class CovidStatsViewModel(
    val country: String,
    val code: String
) {
    object Mapper {

        fun map(country: Country) =
            CovidStatsViewModel(
                country.country,
                country.code
            )

    }
}