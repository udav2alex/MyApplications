package ru.gressor.myapplications.domain

import kotlinx.coroutines.flow.Flow
import ru.gressor.myapplications.domain.entities.App

interface IAppsRepository {
    val appsListFlow: Flow<List<App>>
    suspend fun save(app: App)
    suspend fun remove(app: App)
}