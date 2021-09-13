package ru.gressor.myapplications.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.gressor.myapplications.data.db.entities.StoredApp

@Database(entities = [StoredApp::class], version = 1)
abstract class AppsRoomDatabase : RoomDatabase(), IAppsDatabase {
    abstract override val dao: AppsDao

    companion object {
        fun getDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppsRoomDatabase::class.java,
                DB_FILE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}