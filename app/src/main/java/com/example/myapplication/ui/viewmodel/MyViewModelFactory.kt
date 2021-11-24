package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.database.TaskDao

class MyViewModelFactory(private val taskDao: TaskDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TasksScreenViewModel::class.java)) {
            return TasksScreenViewModel(taskDao) as T
        }
        if (modelClass.isAssignableFrom(NewTaskScreenViewModel::class.java)) {
            return NewTaskScreenViewModel(taskDao) as T
        }
        if (modelClass.isAssignableFrom(EditTaskScreenViewModel::class.java)) {
            return EditTaskScreenViewModel(taskDao) as T
        }
        throw IllegalArgumentException("Never heard of that kind of view model")
    }
}
