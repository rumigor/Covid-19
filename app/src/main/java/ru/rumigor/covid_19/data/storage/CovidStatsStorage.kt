package ru.rumigor.covid_19.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.rumigor.covid_19.data.model.Country

@Database(exportSchema = false, entities = [Country::class], version = 1)
abstract class CovidStatsStorage: RoomDatabase() {
    abstract fun covidStatsDao(): CovidStatsDao
}
