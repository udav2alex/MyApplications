package ru.gressor.myapplications

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import ru.gressor.myapplications.data.db.AppsRoomDatabase
import ru.gressor.myapplications.data.db.AppsSQLiteDatabase
import ru.gressor.myapplications.data.db.IAppsDatabase
import ru.gressor.myapplications.data.repository.AppsRepository
import ru.gressor.myapplications.domain.IAppsRepository
import ru.gressor.myapplications.utils.di.ServiceLocator

@Suppress("unused")
class MyApps : Application() {
    private val locator = ServiceLocator

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        locator.register<Context>(this)
        locator.register<SharedPreferences>(sharedPreferences)

//        val isRoomActive = sharedPreferences.getBoolean(PREFERENCES_KEY_USE_ROOM, false)
        val isRoomActive = false

        if (isRoomActive) {
            locator.register<IAppsDatabase>(AppsRoomDatabase.getDatabase(this))
        } else {
            locator.register<IAppsDatabase>(AppsSQLiteDatabase(this))
        }

        locator.register<IAppsRepository>(AppsRepository())
    }
}

const val PREFERENCES_KEY_USE_ROOM = "PREFERENCES_KEY_USE_ROOM"

