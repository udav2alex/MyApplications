package ru.gressor.myapplications.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.gressor.myapplications.data.db.entities.StoredApp


@Database(entities = [StoredApp::class], version = 2)
abstract class StoredAppsDatabase : RoomDatabase() {
    abstract val dao: AppsDao

    companion object {
        fun getDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                StoredAppsDatabase::class.java,
                "apps-database"
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}