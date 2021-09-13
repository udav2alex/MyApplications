package ru.gressor.myapplications.data.db.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ru.gressor.myapplications.data.db.*
import ru.gressor.myapplications.data.db.entities.StoredApp

class AppsSQLiteOpenHelper(context: Context) :
    SQLiteOpenHelper(context, DB_FILE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DATABASE_CREATE_TABLE_APPS.trimMargin())
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(DB_DROP_TABLE_APPS)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun insert(storedApp: StoredApp) {
        val values = ContentValues().apply {
            put(DB_TABLE_APPS_COLUMN_PACKAGE, storedApp.appPackage)
            put(DB_TABLE_APPS_COLUMN_NAME, storedApp.name)
            put(DB_TABLE_APPS_COLUMN_TAGS, storedApp.tags)
            put(DB_TABLE_APPS_COLUMN_INSTALLED, if (storedApp.isInstalled) 1 else 0)
        }
        writableDatabase.insert(DB_TABLE_NAME_APPS, null, values)
    }

    fun getAllRecords(): List<StoredApp> = mutableListOf<StoredApp>().apply {
        getCursorWithApps().use {
            while (it.moveToNext()) {
                add(
                    StoredApp(
                        it.getInt(0), it.getString(1), it.getString(2), it.getString(3),
                        it.getInt(4) == 0
                    )
                )
            }
        }
    }

    private fun getCursorWithApps(): Cursor =
        readableDatabase.rawQuery("SELECT * FROM $DB_TABLE_NAME_APPS;", null)
}