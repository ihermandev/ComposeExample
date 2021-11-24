package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.database.TaskDao

class TasksScreenViewModel(private val taskDao: TaskDao): ViewModel() {
    fun getTasks() = taskDao.getAll()
}
