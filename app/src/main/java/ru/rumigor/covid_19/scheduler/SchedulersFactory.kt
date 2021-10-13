package ru.rumigor.covid_19.scheduler

object SchedulersFactory {
    fun create(): Schedulers = DefaultSchedulers()
}