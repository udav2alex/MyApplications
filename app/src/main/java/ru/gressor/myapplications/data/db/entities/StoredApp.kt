package ru.gressor.myapplications.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.gressor.myapplications.data.db.*

@Entity(tableName = DB_TABLE_NAME_APPS)
data class StoredApp(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = DB_TABLE_APPS_COLUMN_ID)
    val id: Int = 0,
    @ColumnInfo (name = DB_TABLE_APPS_COLUMN_PACKAGE)
    val appPackage: String,
    @ColumnInfo (name = DB_TABLE_APPS_COLUMN_NAME)
    val name: String,
    @ColumnInfo (name = DB_TABLE_APPS_COLUMN_TAGS)
    val tags: String = "",
    @ColumnInfo (name = DB_TABLE_APPS_COLUMN_INSTALLED)
    val isInstalled: Boolean = false
)