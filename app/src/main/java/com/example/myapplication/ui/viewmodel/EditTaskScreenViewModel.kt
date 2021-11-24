package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.Task
import com.example.myapplication.database.TaskDao
import kotlinx.coroutines.launch

class EditTaskScreenViewModel(private val taskDao: TaskDao) : ViewModel() {
    fun saveTask(task: Task) {
        viewModelScope.launch {
            taskDao.update(task)
        }
    }

    fun getTask(taskId: Long) = taskDao.get(taskId)
}
