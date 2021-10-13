package ru.rumigor.covid_19.scheduler

import io.reactivex.Scheduler


interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler

}