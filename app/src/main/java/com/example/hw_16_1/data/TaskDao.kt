package com.example.hw_16_1.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface TaskDao {
    @Insert()
    fun insertTask(task: Task)
}