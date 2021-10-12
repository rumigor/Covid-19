package ru.rumigor.covid_19.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "country")
data class Country(
    @PrimaryKey
    @SerializedName("code")
    val code: String,
    @ColumnInfo(name = "country")
    @SerializedName("country")
    val country: String,
    @ColumnInfo(name = "confirmed")
    @SerializedName ("confirmed")
    val confirmed: Long,
    @ColumnInfo(name = "recovered")
    @SerializedName("recovered")
    val recovered: Long,
    @ColumnInfo(name = "deaths")
    @SerializedName("deaths")
    val deaths: Long,
    @ColumnInfo(name = "lastUpdate")
    @SerializedName("lastUpdate")
    val lastUpdate: String

)
