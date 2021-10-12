package ru.rumigor.covid_19.data

import javax.inject.Qualifier

@Qualifier
annotation class Cloud

@Qualifier
annotation class Cache

@Qualifier
annotation class InMemory

@Qualifier
annotation class Persisted