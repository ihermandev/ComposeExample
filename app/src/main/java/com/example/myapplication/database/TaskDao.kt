package com.example.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@androidx.room.Dao
interface TaskDao {
    @Insert
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task WHERE id = :key")
    fun get(key: Long): LiveData<Task>

    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): LiveData<List<Task>>
}
