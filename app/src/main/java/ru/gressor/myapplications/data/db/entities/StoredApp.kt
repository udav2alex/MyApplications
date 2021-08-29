package ru.gressor.myapplications.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class StoredApp(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val appPackage: String,
    val name: String,
    val tags: String = "",
    val isInstalled: Boolean = false
)