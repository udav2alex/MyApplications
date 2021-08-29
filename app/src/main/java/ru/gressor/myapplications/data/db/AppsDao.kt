package ru.gressor.myapplications.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.gressor.myapplications.data.db.entities.StoredApp

@Dao
interface AppsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(storedApp: StoredApp)

    @Update
    suspend fun update(storedApp: StoredApp)

    @Delete
    suspend fun delete(storedApp: StoredApp)

    @Query("SELECT * FROM apps")
    fun getAll(): Flow<List<StoredApp>>
}