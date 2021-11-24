package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.Task
import com.example.myapplication.database.TaskDao
import kotlinx.coroutines.launch

class NewTaskScreenViewModel(private val taskDao: TaskDao): ViewModel() {
    fun addTask(task: Task) {
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }
}
