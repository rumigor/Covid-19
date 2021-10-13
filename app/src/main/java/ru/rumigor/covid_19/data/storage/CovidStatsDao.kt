package ru.rumigor.covid_19.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.rumigor.covid_19.data.model.Country

@Dao
interface CovidStatsDao {
    @Query("SELECT * FROM country")
    fun fetchCountriesList(): Observable<List<Country>>

    @Query("SELECT * FROM country WHERE response LIKE :country LIMIT 1")
    fun fetchCountryByCode(country: String): Single<Country>

    @Insert(onConflict = REPLACE)
    fun retain(users: List<Country>): Completable

    @Update(onConflict = REPLACE)
    fun retain(country: Country): Completable
}