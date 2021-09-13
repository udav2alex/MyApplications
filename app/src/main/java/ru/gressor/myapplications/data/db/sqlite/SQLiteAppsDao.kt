package ru.gressor.myapplications.data.db.sqlite

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.gressor.myapplications.data.db.AppsDao
import ru.gressor.myapplications.data.db.entities.StoredApp

class SQLiteAppsDao(val context: Context) : AppsDao {
    private val dbHelper = AppsSQLiteOpenHelper(context)
    private val allItemsFlow = MutableStateFlow(dbHelper.getAllRecords())

    override fun getAll(): Flow<List<StoredApp>> = allItemsFlow.asStateFlow()

    override suspend fun insert(storedApp: StoredApp) {
        dbHelper.insert(storedApp)
        updateFlow()
    }

    override suspend fun update(storedApp: StoredApp) {
//        TODO("Not yet implemented")
        updateFlow()
    }

    override suspend fun delete(storedApp: StoredApp) {
//        TODO("Not yet implemented")
        updateFlow()
    }

    private fun updateFlow() {
        allItemsFlow.value = dbHelper.getAllRecords()
    }
}