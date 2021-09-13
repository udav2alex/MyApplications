package ru.gressor.myapplications.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.gressor.myapplications.data.db.IAppsDatabase
import ru.gressor.myapplications.domain.IAppsRepository
import ru.gressor.myapplications.domain.entities.App
import ru.gressor.myapplications.utils.di.locateLazily

class AppsRepository : IAppsRepository {
    private val database: IAppsDatabase by locateLazily()
    private val dao get() = database.dao

    override val appsListFlow: Flow<List<App>> = dao.getAll().map { storedList ->
        storedList.map { storedApp -> storedApp.toApp() }
    }

    override suspend fun save(app: App) = dao.insert(app.toStoredApp())

    override suspend fun remove(app: App) = dao.delete(app.toStoredApp())

    override suspend fun update(app: App) = dao.update(app.toStoredApp())
}