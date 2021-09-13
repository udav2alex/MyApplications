package ru.gressor.myapplications.data.db

import android.content.Context
import ru.gressor.myapplications.data.db.sqlite.SQLiteAppsDao

class AppsSQLiteDatabase(context: Context) : IAppsDatabase {
    override val dao: AppsDao = SQLiteAppsDao(context)
}

