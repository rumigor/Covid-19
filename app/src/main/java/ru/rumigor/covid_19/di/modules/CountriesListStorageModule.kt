package ru.rumigor.covid_19.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.rumigor.covid_19.data.InMemory
import ru.rumigor.covid_19.data.Persisted
import ru.rumigor.covid_19.data.storage.CovidStatsStorage

@Module
class CountriesListStorageModule {

    @Persisted
    @Provides
    fun provideCovidStatsDatabaseStorage(context: Context): CovidStatsStorage =
        Room.databaseBuilder(context, CovidStatsStorage::class.java, "countries.db")
            .build()

    @InMemory
    @Provides
    fun provideCovidStatsInMemoryDatabaseStorage(context: Context): CovidStatsStorage =
        Room.inMemoryDatabaseBuilder(context, CovidStatsStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

}