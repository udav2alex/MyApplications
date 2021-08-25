package ru.gressor.myapplications

import android.app.Application
import android.content.Context
import ru.gressor.myapplications.data.db.StoredAppsDatabase
import ru.gressor.myapplications.data.repository.AppsRepository
import ru.gressor.myapplications.domain.IAppsRepository
import ru.gressor.myapplications.utils.di.ServiceLocator

@Suppress("unused")
class MyApps : Application() {
    private val locator = ServiceLocator

    override fun onCreate() {
        super.onCreate()

        locator.register<Context>(this)
        locator.register(StoredAppsDatabase.getDatabase(this))
        locator.register<IAppsRepository>(AppsRepository())
    }
}

